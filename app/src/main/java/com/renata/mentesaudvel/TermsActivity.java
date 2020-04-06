package com.renata.mentesaudvel;

import android.os.Bundle;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class TermsActivity extends AppCompatActivity {
    private TextView title, detail;
    private String title_info = "";
    private String detail_info = "";
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_term);
        title = (TextView) findViewById(R.id.term_title);
        detail = (TextView) findViewById(R.id.term_detail);
        title.setText(title_info);
        detail.setText(detail_info);
    }
}
