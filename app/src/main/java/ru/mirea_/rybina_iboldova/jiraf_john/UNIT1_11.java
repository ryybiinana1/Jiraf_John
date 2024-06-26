package ru.mirea_.rybina_iboldova.jiraf_john;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class UNIT1_11 extends AppCompatActivity {

    private TextView textView3_unit1_1;
    private Button button5_unit1_1, button6_unit1_1, button7_unit1_1, button2_unit1_1;
    private String correctAnswer = "is";

    private boolean IsAnswered = false;
    private Intent intent;

    InternalStorage storage = new InternalStorage(this);

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_unit1_11);

        textView3_unit1_1 = findViewById(R.id.textView3_unit1_1);
        button5_unit1_1 = findViewById(R.id.button5_unit1_1);
        button6_unit1_1 = findViewById(R.id.button6_unit1_1);
        button7_unit1_1 = findViewById(R.id.button7_unit1_1);
        button2_unit1_1 = findViewById(R.id.button2_unit1_15);

        setAnswerButtonListeners();
        GlobalState globalState = GlobalState.getInstance();
        globalState.maxAnswers = 6;
        globalState.myAnswers = 0;
        button2_unit1_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (IsAnswered) {
                    // Здесь код, который будет выполнен при клике на button4_unit1_1
                    intent = new Intent(UNIT1_11.this, UNIT1_12.class);
                    startActivity(intent);
                } else {
                    Toast.makeText(UNIT1_11.this, "Need answer!", Toast.LENGTH_SHORT).show();
                }

            }
        });
    }
    private void setAnswerButtonListeners() {
        View.OnClickListener answerButtonClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Button clickedButton = (Button) view;
                String answerText = clickedButton.getText().toString();

                if (answerText.equals(correctAnswer)) {
                    GlobalState globalState = GlobalState.getInstance();
                    globalState.addMyAnswers();
                    clickedButton.setBackgroundColor(Color.rgb(255, 215, 0));
                    Toast.makeText(UNIT1_11.this, "Right!", Toast.LENGTH_SHORT).show();
                } else {
                    clickedButton.setBackgroundColor(Color.rgb(61, 61, 61));
                }
                IsAnswered = true;

                disableAnswerButtons();
            }
        };

        button5_unit1_1.setOnClickListener(answerButtonClickListener);
        button6_unit1_1.setOnClickListener(answerButtonClickListener);
        button7_unit1_1.setOnClickListener(answerButtonClickListener);
    }


    private void disableAnswerButtons() {
        button5_unit1_1.setEnabled(false);
        button6_unit1_1.setEnabled(false);
        button7_unit1_1.setEnabled(false);
    }
}