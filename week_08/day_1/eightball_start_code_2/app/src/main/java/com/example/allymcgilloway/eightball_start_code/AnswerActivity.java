package com.example.allymcgilloway.eightball_start_code;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class AnswerActivity extends AppCompatActivity {

    private TextView answerField;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_answer);

        // Link answerField to the UI answer_text.
        answerField = findViewById(R.id.answer_text);

        // Get the information from the intent's extras.
        Intent intent = getIntent();
        Bundle extras = intent.getExtras();
        String answer = extras.getString("answer");


        answerField.setText(answer);
    }
}
