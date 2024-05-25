package ru.mirea_.rybina_iboldova.jiraf_john;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Color;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class Unit14 extends AppCompatActivity {

    private MediaPlayer mPlayer;
    private Button playButton, pauseButton, stopButton, button_first_answer, button_second_answer;
    private Button button_next_to5;
    private Intent intent;
    private String correctAnswer = "Steve is ill. He is in bed";
    private boolean IsAnswered = false;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_unit1_41);

        mPlayer = MediaPlayer.create(this, R.raw.steve2); // Замените R.raw.beautiful_woman на ваш файл аудио
        mPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                stopPlay();
            }
        });

        playButton = findViewById(R.id.playButton);
        pauseButton = findViewById(R.id.pauseButton);
        stopButton = findViewById(R.id.stopButton);

        pauseButton.setEnabled(false);
        stopButton.setEnabled(false);

        button_next_to5 = findViewById(R.id.button_next_to5);
        button_next_to5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (IsAnswered) {
                    // Здесь код, который будет выполнен при клике на No_password
                    intent = new Intent(Unit14.this, UNIT1_5.class);
                    startActivity(intent);
                }else{
                    Toast.makeText(Unit14.this, "Need answer!", Toast.LENGTH_SHORT).show();
                }
            }
        });

        button_first_answer = findViewById(R.id.button_first_answer);
        button_second_answer = findViewById(R.id.button_second_answer);
        setAnswerButtonListeners();
    }
    private void setAnswerButtonListeners() {
        View.OnClickListener answerButtonClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Button clickedButton = (Button) view;
                String answerText = clickedButton.getText().toString();

                if (answerText.equals(correctAnswer)) {
                    clickedButton.setBackgroundColor(Color.rgb(255, 215, 0));
                    Toast.makeText(Unit14.this, "Right!", Toast.LENGTH_SHORT).show();
                } else {
                    clickedButton.setBackgroundColor(Color.rgb(61, 61, 61));
                }
                IsAnswered = true;
                disableAnswerButtons();
            }
        };

        button_first_answer.setOnClickListener(answerButtonClickListener);
        button_second_answer.setOnClickListener(answerButtonClickListener);
    }


    private void disableAnswerButtons() {
        button_first_answer.setEnabled(false);
        button_second_answer.setEnabled(false);
    }

    private void stopPlay() {
        if (mPlayer != null) {
            mPlayer.stop();
            pauseButton.setEnabled(false);
            stopButton.setEnabled(false);
            try {
                mPlayer.prepare();
                mPlayer.seekTo(0);
                playButton.setEnabled(true);
            } catch (Throwable t) {
                Toast.makeText(this, t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        }
    }

    public void play(View view) {
        if (mPlayer != null && !mPlayer.isPlaying()) {
            mPlayer.start();
            playButton.setEnabled(false);
            pauseButton.setEnabled(true);
            stopButton.setEnabled(true);
        }
    }

    public void pause(View view) {
        if (mPlayer != null && mPlayer.isPlaying()) {
            mPlayer.pause();
            playButton.setEnabled(true);
            pauseButton.setEnabled(false);
            stopButton.setEnabled(true);
        }
    }

    public void stop(View view) {
        stopPlay();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if (mPlayer != null) {
            if (mPlayer.isPlaying()) {
                stopPlay();
            }
            mPlayer.release();
            mPlayer = null;
        }
    }
}
