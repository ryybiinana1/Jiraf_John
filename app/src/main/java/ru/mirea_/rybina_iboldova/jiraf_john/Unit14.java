package ru.mirea_.rybina_iboldova.jiraf_john;

import android.annotation.SuppressLint;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class Unit14 extends AppCompatActivity {

    private MediaPlayer mPlayer;
    private Button playButton, pauseButton, stopButton;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_unit14);

        mPlayer = MediaPlayer.create(this, R.raw.beautiful_woman); // Замените R.raw.beautiful_woman на ваш файл аудио
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
