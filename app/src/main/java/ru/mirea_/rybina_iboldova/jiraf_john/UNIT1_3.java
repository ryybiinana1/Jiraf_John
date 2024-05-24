package ru.mirea_.rybina_iboldova.jiraf_john;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class UNIT1_3 extends AppCompatActivity {

    private TextView questionText;
    private Button answer1, answer2, answer3, answer4;
    private String correctAnswer = "Java";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_unit1_3);

        questionText = findViewById(R.id.question_text);
        answer1 = findViewById(R.id.answer_1);
        answer2 = findViewById(R.id.answer_2);
        answer3 = findViewById(R.id.answer_3);
        answer4 = findViewById(R.id.answer_4);

        setAnswerButtonListeners();
    }

    private void setAnswerButtonListeners() {
        View.OnClickListener answerButtonClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Button clickedButton = (Button) view;
                String answerText = clickedButton.getText().toString();

                if (answerText.equals(correctAnswer)) {
                    clickedButton.setBackgroundColor(Color.GREEN);
                } else {
                    clickedButton.setBackgroundColor(Color.RED);
                }

                disableAnswerButtons();
            }
        };

        answer1.setOnClickListener(answerButtonClickListener);
        answer2.setOnClickListener(answerButtonClickListener);
        answer3.setOnClickListener(answerButtonClickListener);
        answer4.setOnClickListener(answerButtonClickListener);
    }

    private void disableAnswerButtons() {
        answer1.setEnabled(false);
        answer2.setEnabled(false);
        answer3.setEnabled(false);
        answer4.setEnabled(false);
    }
}