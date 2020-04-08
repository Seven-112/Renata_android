package com.renata.mentesaudvel;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.preference.MultiSelectListPreference;
import android.provider.MediaStore;
import android.text.InputType;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.MultiAutoCompleteTextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.OnProgressListener;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;
import com.renata.mentesaudvel.Adapter.ReadDetailAdapter;
import com.renata.mentesaudvel.Model.ReadItem;
import com.renata.mentesaudvel.Model.Reading;
import com.squareup.picasso.Picasso;
import com.theartofdev.edmodo.cropper.CropImage;
import com.theartofdev.edmodo.cropper.CropImageView;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import static android.graphics.text.LineBreaker.HYPHENATION_FREQUENCY_NONE;

public class ReadingListAdminActivity extends AppCompatActivity {

    String[] itemname = {};
    DatabaseReference databaseReference;
    Button addChildBtn,editTxtBtn, audio1Btn,audio2Btn,videoBtn,deleteBtn;
    ImageView sectionImage;
    ListView listChild;
    EditText nameTV;
    List<ReadItem> readitems= new ArrayList<>();
    private ReadDetailAdapter readDetailAdapter;
    private static final int GalleryPick = 1;
    private ProgressDialog loadingBar;
    private final int PICK_FILE_REQUEST = 11;
    private final int PICK_FILE_REQUEST2 = 10;
    private final int PICK_VIDEO_REQUEST = 12;
    private StorageReference userProfileImageRef,storageReference;
    private Uri filePath, filePathdoc,filePathdoc2,videoPathdoc;
    Boolean scrollkey = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_readinglist);

        Bundle extra = getIntent().getExtras();
        final String readingID = extra.getString("readingid");

        databaseReference = FirebaseDatabase.getInstance().getReference("Readings").child(readingID);
        userProfileImageRef = FirebaseStorage.getInstance().getReference().child("Profile Images");
        storageReference = FirebaseStorage.getInstance().getReference().child("Audios");

        addChildBtn = (Button) findViewById(R.id.buttonAddChild);
        editTxtBtn = (Button) findViewById(R.id.editTxtBtn);
        sectionImage = (ImageView) findViewById(R.id.sectionImage);
        listChild = (ListView) findViewById(R.id.listChild);
        nameTV = (EditText) findViewById(R.id.sectiontitle);

        audio1Btn = (Button) findViewById(R.id.firstAudio) ;
        audio2Btn = (Button) findViewById(R.id.secondAudio) ;
        videoBtn = (Button) findViewById(R.id.video) ;
        deleteBtn = (Button) findViewById(R.id.delete) ;

        audio1Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_GET_CONTENT);
                intent.putExtra(Intent.EXTRA_ALLOW_MULTIPLE, true);
                intent.setType("audio/*");
                startActivityForResult(Intent.createChooser(intent, "Select Files"), PICK_FILE_REQUEST);
            }
        });
        audio2Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_GET_CONTENT);
                intent.putExtra(Intent.EXTRA_ALLOW_MULTIPLE, true);
                intent.setType("audio/*");
                startActivityForResult(Intent.createChooser(intent, "Select Files"), PICK_FILE_REQUEST2);
            }
        });

        videoBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_GET_CONTENT);
                intent.putExtra(Intent.EXTRA_ALLOW_MULTIPLE, true);
                intent.setType("video/*");
                startActivityForResult(Intent.createChooser(intent, "Select Files"), PICK_VIDEO_REQUEST);
            }
        });

        deleteBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder1 = new AlertDialog.Builder(ReadingListAdminActivity.this);
                builder1.setTitle("Deseja formatar todos os arquivos de mídia?");
                builder1.setCancelable(true);

                builder1.setPositiveButton(
                        "sim",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                databaseReference.child("reading_first_file").setValue("default");
                                databaseReference.child("reading_second_file").setValue("default");
                                databaseReference.child("reading_third_file").setValue("default");

                                Toast.makeText(ReadingListAdminActivity.this, "All files has been deleted.", Toast.LENGTH_SHORT).show();

                            }
                        });

                builder1.setNegativeButton(
                        "não",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                dialog.cancel();
                            }
                        });

                AlertDialog alert11 = builder1.create();
                alert11.setIcon(R.drawable.warning);
                alert11.show();
            }
        });

        loadingBar = new ProgressDialog(this);
        nameTV.setEnabled(false);
//        Toast.makeText(ReadingListAdminActivity.this,""+readingID,Toast.LENGTH_SHORT).show();
        databaseReference.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                String imgID = dataSnapshot.child("reading_image").getValue(String.class);
                String name = dataSnapshot.child("reading_name").getValue(String.class);

                String first_file = dataSnapshot.child("reading_first_file").getValue(String.class);
                String second_file = dataSnapshot.child("reading_second_file").getValue(String.class);
                String third_file = dataSnapshot.child("reading_third_file").getValue(String.class);

                if(!first_file.equals("default")){
                    audio1Btn.setBackgroundResource(R.drawable.uploaded_btn);
                }
                if(!second_file.equals("default")){
                    audio2Btn.setBackgroundResource(R.drawable.uploaded_btn);
                }
                if(!third_file.equals("default")){
                    videoBtn.setBackgroundResource(R.drawable.uploaded_btn);
                }

                if(imgID.equals( "default" )){
                    Picasso.get().load(R.drawable.newitem).into(sectionImage);
                }
                else {
                    Picasso.get().load(imgID).into(sectionImage);
                }
                nameTV.setText(name);

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

        editTxtBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(nameTV.isEnabled()){
                    nameTV.setEnabled(false);
                    databaseReference.child("reading_name").setValue(nameTV.getText().toString());
                    editTxtBtn.setText("Editar título");
                }else{
                    nameTV.setEnabled(true);
                    editTxtBtn.setText("Atualizar");
                }
            }
        });

        addChildBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String id = databaseReference.child("items").push().getKey();
                ReadItem Item = new ReadItem(id, "default","Clique aqui para editar novos conteúdos.");
                //Saving the Item
                databaseReference.child("items").child(id).setValue(Item);
                scrollkey = false;
//                Toast.makeText(ReadingListAdminActivity.this,"An... Item Added.",Toast.LENGTH_SHORT).show();
                scrollkey = false;
            }
        });

        sectionImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent galleryIntent = new Intent();
                galleryIntent.setAction(Intent.ACTION_GET_CONTENT);
                galleryIntent.setType("image/*");
                startActivityForResult(galleryIntent, GalleryPick);
            }
        });

        readDetailAdapter = new ReadDetailAdapter(ReadingListAdminActivity.this, readitems );

        listChild.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, final int position, final long id) {
                AlertDialog.Builder alert = new AlertDialog.Builder(ReadingListAdminActivity.this);
                final EditText edittext = new EditText(ReadingListAdminActivity.this);
//                edittext.setInputType( InputType.TYPE_TEXT_FLAG_CAP_SENTENCES | HYPHENATION_FREQUENCY_NONE);

                alert.setTitle("Edite o conteúdo.");

                alert.setView(edittext);
                ReadItem Item = readitems.get(position);
                String detail= Item.getreaditem_detail();
                edittext.setText(detail);

                alert.setPositiveButton("Atualizar", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        String updateText = edittext.getText().toString();
                        ReadItem Item = readitems.get(position);
                        String readingID= Item.getreaditem_id();
                        updateItem(readingID,updateText);

                    }
                });

                alert.setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int whichButton) {

                        dialog.cancel();
                    }
                });
                alert.show();
            }
        });

        listChild.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, final int position, long id) {
                AlertDialog.Builder builder1 = new AlertDialog.Builder(ReadingListAdminActivity.this);
                builder1.setTitle("Deseja excluir este conteúdo?");
                builder1.setCancelable(true);

                builder1.setPositiveButton(
                        "sim",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                ReadItem Item = readitems.get(position);
                                String readingID= Item.getreaditem_id();
                                deleteItem(readingID);
                            }
                        });

                builder1.setNegativeButton(
                        "não",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                dialog.cancel();
                            }
                        });

                AlertDialog alert11 = builder1.create();
                alert11.setIcon(R.drawable.warning);
                alert11.show();

                return true;
            }
        });



    }
    @Override
    public void onStart() {
        super.onStart();
        databaseReference.child("items").addValueEventListener(mValueEventListener);

    }

    ValueEventListener mValueEventListener = new ValueEventListener() {
        @Override
        public void onDataChange(DataSnapshot dataSnapshot) {

            //clearing the previous Item list
            readitems.clear();
            //getting all nodes
            for (DataSnapshot postSnapshot : dataSnapshot.getChildren()) {

                //getting Item from firebase console
                ReadItem Item = postSnapshot.getValue(ReadItem.class);

                readitems.add( Item );
            }
            if(!scrollkey){

                listChild.post(new Runnable(){
                    public void run() {
                        listChild.setSelection(listChild.getCount() - 1);
                    }});
            }
            listChild.setAdapter(readDetailAdapter);

//            listChild.scrollTo(0, listChild.getBottom());
//            pd.dismiss();

        }

        @Override
        public void onCancelled(DatabaseError databaseError) {

        }


    };

    private boolean deleteItem(String id) {
        //getting the specified Item reference
        DatabaseReference DeleteReference = databaseReference.child("items").child(id);
        //removing Item
        DeleteReference.removeValue();
        Toast.makeText(ReadingListAdminActivity.this, "Excluído!", Toast.LENGTH_LONG).show();
        return true;

    }
    private boolean updateItem(String id,String detail) {
        //getting the specified Item reference
        DatabaseReference UpdateReference = databaseReference.child("items").child(id);
        //removing Item
        ReadItem Item = new ReadItem( id, "default", detail);
        //update  Item  to firebase
        UpdateReference.setValue( Item );
        Toast.makeText(ReadingListAdminActivity.this, "Atualizado!", Toast.LENGTH_LONG).show();
        return true;

    }




    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == GalleryPick && resultCode == RESULT_OK && data != null) {
            Uri ImageUri = data.getData();
            // start picker to get image for cropping and then use the image in cropping activity
            CropImage.activity()
                    .setGuidelines(CropImageView.Guidelines.ON)
                    .setAspectRatio(11, 4)
                    .start(ReadingListAdminActivity.this);
        }

        if (requestCode == CropImage.CROP_IMAGE_ACTIVITY_REQUEST_CODE) {
            CropImage.ActivityResult result = CropImage.getActivityResult(data);
            if (resultCode == RESULT_OK) {

                loadingBar.setTitle(R.string.set_profile_image);
                loadingBar.setMessage("Please wait, your profile image is uploading");
                loadingBar.setCanceledOnTouchOutside(false);
                loadingBar.show();

                final Uri resultUri = result.getUri();
                final StorageReference filePath = userProfileImageRef.child(UUID.randomUUID().toString() + ".jpg");

                filePath.putFile(resultUri)
                        .continueWithTask(new Continuation<UploadTask.TaskSnapshot, Task<Uri>>() {
                            @Override
                            public Task<Uri> then(@NonNull Task<UploadTask.TaskSnapshot> task) throws Exception {
                                if (!task.isSuccessful()) {
                                    throw task.getException();
                                }
                                Bitmap bitmap = MediaStore.Images.Media.getBitmap(ReadingListAdminActivity.this.getContentResolver(), resultUri);
                                sectionImage.setImageBitmap(bitmap);
                                // Continue with the task to get the download URL
                                return filePath.getDownloadUrl();
                            }
                        }).addOnCompleteListener(new OnCompleteListener<Uri>() {
                    @Override
                    public void onComplete(@NonNull Task<Uri> task) {
                        if (task.isSuccessful()) {
                            final String downloadUri = task.getResult().toString();
                            databaseReference.child("reading_image")
                                    .setValue(downloadUri)
                                    .addOnCompleteListener(new OnCompleteListener<Void>() {
                                        @Override
                                        public void onComplete(@NonNull Task<Void> task) {
                                            if (task.isSuccessful()) {
                                                // Toast.makeText(SettingsActivity.this, "Image save on database, successfully...", Toast.LENGTH_SHORT).show();
                                                loadingBar.dismiss();
                                            } else {
                                                String message = task.getException().toString();
                                                Toast.makeText(ReadingListAdminActivity.this, "Error : " + message, Toast.LENGTH_SHORT).show();
                                                loadingBar.dismiss();
                                            }
                                        }
                                    });
                        } else {
                            String message = task.getException().toString();
                            Toast.makeText(ReadingListAdminActivity.this, "Error : " + message, Toast.LENGTH_SHORT).show();
                            loadingBar.dismiss();
                        }
                    }
                });
            } else if (resultCode == CropImage.CROP_IMAGE_ACTIVITY_RESULT_ERROR_CODE) {
                Exception error = result.getError();
            }
        }

        if(requestCode == PICK_FILE_REQUEST && resultCode == RESULT_OK
                && data != null && data.getData() != null )
        {
            filePathdoc = data.getData();
            Uri returnUri = data.getData();
            String src = returnUri.getPath();
            String file = src.substring(src.lastIndexOf("/")+1, src.length());
//            audio1Btn.setText(file);
        }
        if(filePathdoc != null)
        {
            final ProgressDialog progressDialog = new ProgressDialog(ReadingListAdminActivity.this);
            progressDialog.setTitle("Uploading...");
            progressDialog.show();

//            String substr =attached_fileName.getText().toString().substring(attached_fileName.getText().toString().indexOf("."));

            final StorageReference ref = storageReference.child(audio1Btn.getText().toString().trim());


            ref.putFile(filePathdoc)
                    .addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
                        @Override
                        public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                            progressDialog.dismiss();
//                            Toast.makeText(ReadingListAdminActivity.this, "Uploaded", Toast.LENGTH_SHORT).show();
                            //TODO; download URL getting
                            ref.getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
                                @Override
                                public void onSuccess(Uri uri) {
                                    String downURL_file = uri.toString();
                                    databaseReference.child("reading_first_file").setValue(downURL_file);
                                    audio1Btn.setBackgroundResource(R.drawable.uploaded_btn);

                                }
                            });
                        }
                    })
                    .addOnFailureListener(new OnFailureListener() {
                        @Override
                        public void onFailure(@NonNull Exception e) {
                            progressDialog.dismiss();
                            Toast.makeText(ReadingListAdminActivity.this, "Failed "+e.getMessage(), Toast.LENGTH_SHORT).show();
                        }
                    })
                    .addOnProgressListener(new OnProgressListener<UploadTask.TaskSnapshot>() {
                        @Override
                        public void onProgress(UploadTask.TaskSnapshot taskSnapshot) {
                            double progress = (100.0*taskSnapshot.getBytesTransferred()/taskSnapshot
                                    .getTotalByteCount());
                            progressDialog.setMessage("Uploaded "+(int)progress+"%");
                        }
                    });
        }

        if(requestCode == PICK_FILE_REQUEST2 && resultCode == RESULT_OK
                && data != null && data.getData() != null )
        {
            filePathdoc2 = data.getData();
            Uri returnUri = data.getData();
            String src = returnUri.getPath();
            String file = src.substring(src.lastIndexOf("/")+1, src.length());
//            audio2Btn.setText(file);
        }
        if(filePathdoc2 != null)
        {
            final ProgressDialog progressDialog = new ProgressDialog(ReadingListAdminActivity.this);
            progressDialog.setTitle("Uploading...");
            progressDialog.show();

//            String substr =attached_fileName.getText().toString().substring(attached_fileName.getText().toString().indexOf("."));

            final StorageReference ref = storageReference.child(audio2Btn.getText().toString().trim());


            ref.putFile(filePathdoc2)
                    .addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
                        @Override
                        public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                            progressDialog.dismiss();
//                            Toast.makeText(ReadingListAdminActivity.this, "Uploaded", Toast.LENGTH_SHORT).show();
                            //TODO; download URL getting
                            ref.getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
                                @Override
                                public void onSuccess(Uri uri) {
                                    String downURL_file = uri.toString();
                                    databaseReference.child("reading_second_file").setValue(downURL_file);
                                    audio2Btn.setBackgroundResource(R.drawable.uploaded_btn);
                                }
                            });
                        }
                    })
                    .addOnFailureListener(new OnFailureListener() {
                        @Override
                        public void onFailure(@NonNull Exception e) {
                            progressDialog.dismiss();
                            Toast.makeText(ReadingListAdminActivity.this, "Failed "+e.getMessage(), Toast.LENGTH_SHORT).show();
                        }
                    })
                    .addOnProgressListener(new OnProgressListener<UploadTask.TaskSnapshot>() {
                        @Override
                        public void onProgress(UploadTask.TaskSnapshot taskSnapshot) {
                            double progress = (100.0*taskSnapshot.getBytesTransferred()/taskSnapshot
                                    .getTotalByteCount());
                            progressDialog.setMessage("Uploaded "+(int)progress+"%");
                        }
                    });
        }

        if(requestCode == PICK_VIDEO_REQUEST && resultCode == RESULT_OK
                && data != null && data.getData() != null )
        {
            videoPathdoc = data.getData();
            Uri returnUri = data.getData();
            String src = returnUri.getPath();
            String file = src.substring(src.lastIndexOf("/")+1, src.length());
//            videoBtn.setText(file);
        }

        if(videoPathdoc != null)
        {
            final ProgressDialog progressDialog = new ProgressDialog(ReadingListAdminActivity.this);
            progressDialog.setTitle("Uploading...");
            progressDialog.show();

//            String substr =attached_fileName.getText().toString().substring(attached_fileName.getText().toString().indexOf("."));

            final StorageReference ref = storageReference.child(videoBtn.getText().toString().trim());


            ref.putFile(videoPathdoc)
                    .addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
                        @Override
                        public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                            progressDialog.dismiss();
//                            Toast.makeText(ReadingListAdminActivity.this, "Uploaded", Toast.LENGTH_SHORT).show();
                            //TODO; download URL getting
                            ref.getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
                                @Override
                                public void onSuccess(Uri uri) {
                                    String downURL_file = uri.toString();
                                    databaseReference.child("reading_third_file").setValue(downURL_file);
                                    videoBtn.setBackgroundResource(R.drawable.uploaded_btn);
                                }
                            });
                        }
                    })
                    .addOnFailureListener(new OnFailureListener() {
                        @Override
                        public void onFailure(@NonNull Exception e) {
                            progressDialog.dismiss();
                            Toast.makeText(ReadingListAdminActivity.this, "Failed "+e.getMessage(), Toast.LENGTH_SHORT).show();
                        }
                    })
                    .addOnProgressListener(new OnProgressListener<UploadTask.TaskSnapshot>() {
                        @Override
                        public void onProgress(UploadTask.TaskSnapshot taskSnapshot) {
                            double progress = (100.0*taskSnapshot.getBytesTransferred()/taskSnapshot
                                    .getTotalByteCount());
                            progressDialog.setMessage("Uploaded "+(int)progress+"%");
                        }
                    });
        }
    }
}
