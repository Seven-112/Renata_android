package com.renata.mentesaudvel;

import android.os.Bundle;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class TermsActivity extends AppCompatActivity {
    private TextView title, detail;
    private String title_info = "dsdsadsadsad";
    private String detail_info = "Hi, Greetings\n" +
            "I am passionate and professional app developer.\n" +
            " I can build your app perfectly.\n" +
            " I do my best for fulfill client's opinion.\n" +
            " I build all mobile apps with creative and original ideas.\n" +
            "Initiate chat for further discussion and I will show you my project done and my experience toward the project.\n" +
            "thanks\n" +
            "===\n" +
            "\n" +
            "⭐ Hello, Sir! ⭐\n" +
            "Nice to meet you.\n" +
            "I am a mobile app developer with RICH experience.\n" +
            "It's just me whom you are looking for.\n" +
            "I am ready for your project now.\n" +
            "I can do it and start right now and work for you with fulltime manner.\n" +
            "I would like to have a more detailed discussion with you on the chat.\n" +
            "\n" +
            "Thank for your kind reading.\n" +
            "\n" +
            "Creating Barber App\n" +
            "Hope you are doing well.\n" +
            "I am Android expert. \n" +
            "I can do your project using Native Android Java. \n" +
            "I have rich experience about the android and iOS native apps.\n" +
            "I can build perfect project with you. \n" +
            "When you have free time,let me know please.\n" +
            "\n" +
            "I hope long term relationship with you.\n" +
            "\n" +
            "Best Regards.\n" +
            "\n" +
            "Senior an android app developer.\n" +
            "\n" +
            "I've carefully gone through your job description and so I am very interested in your android project.\n" +
            "I have developed many android applications involving various functionalities\n" +
            "\n" +
            "\n" +
            "As a professional android app developer with more than 5 years of experience, I have the confidence to complete the project within the specified time.\n" +
            "I can satisfy all of your requirements and make it what you want in real.\n" +
            "I can start your android project immediately and finish your android project successfully within a given time frame with high quality.\n" +
            "We can discuss more details on chat. Please give me the opportunity to demonstrate android project in more detail.\n" +
            "\n" +
            "Thank you in advance.\n" +
            "\n" +
            "\n" +
            "Hi there,\n" +
            "I am professional Android/IOS and I will complete all requirements according to you and I have the experience of 4 + Years in my job related field of Android/IOS App development.\n" +
            "According to your job post requirements I am totally relating towards what you need , I am sure that I will meet your requirements . My background with this Field is remarkable I worked on many Android/IOS Apps for this purpose . My desired goal is to provide you the best services while meeting your requirements and I will make a check list for client satisfaction as well.\n" +
            "I assure you that the application will be according to your requirements and also timely support and daily updates are provided by me.\n" +
            "\n" +
            "Looking for a Chance to prove my Expertise.\n" +
            "Thanks & Regards\n" +
            "...\n" +
            "\n" +
            "Hi Khalid\n" +
            "\n" +
            "I am a full stack web/mobile app developer who has vast experience for over 5 years.\n" +
            "Your job is really caught my eyes because my experience and expertise are perfect match for your job.\n" +
            "\n" +
            "1. I have all skills to lead this job to success!!!\n" +
            "I have very high skill with React Native and Java. I've developed 80+ mobile apps so far.\n" +
            "I'm aiming at building the highest quality apps more competitive than others in the market.\n" +
            "2. I can start development right away and I can work full time(40+ hours per week).\n" +
            "3. I am available to work on your timezone.\n" +
            "4. I have rich experience with source & task management tools such as Trello/Asana/Jira and Github/Bitbucket.\n" +
            "5. I'll provide you 6+ months of free bug fixing and maintain.\n" +
            "6. I can discount my price to build our long term relationship.\n" +
            "\n" +
            "Availability:\n" +
            "* BEST QUALITY\n" +
            "* CLIENT’s SATISFACTION\n" +
            "* AMAZING SPEED\n" +
            "* FULL TIME HARD WORKING\n" +
            "* PROFESSIONAL COMMUNICATION\n" +
            "\n" +
            "Looking forward for your valuable response.\n" +
            "Best regards.\n" +
            "...\n";
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
