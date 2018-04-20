package com.example.allymcgilloway.eightball_start_code;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private EditText questionEditText;
    private Button shakeButton;
    private TextView answerTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        Log.d("MainActivity", "onCreate: log 1");

        questionEditText = findViewById(R.id.question);
        shakeButton = findViewById(R.id.shake_button);
        answerTextView = findViewById(R.id.answer_textview);
    }

    public void onShakeButtonClicked(View clickedView){
        Log.d("Main Activity", "shake button clicked");
        String questionThatWasAsked = questionEditText.getText().toString();
        Log.d("Main Activity", questionThatWasAsked);

        String answer = new Answer().getRandomAnswer();
//        answerTextView.setText(answer);

        // First argument is where we're coming from.
        // Second argument is where we want to go.
        Intent intent = new Intent(this, AnswerActivity.class );

        // We attach extra information ('extra') to the intent using .putExtra() method.
        intent.putExtra("answer", answer);

        // Anytime you start a new activity, it overlays the old activity.
        startActivity(intent);
    }
}
