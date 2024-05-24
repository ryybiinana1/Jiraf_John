package ru.mirea_.rybina_iboldova.jiraf_john;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Introduction_UNIT1 extends AppCompatActivity {

    private Button Button_i;
    private TextView Let_start;

    private Intent intent;
    private TextView Unit1;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_introduction_unit1);

        Button_i = findViewById(R.id.button_i);
        Let_start = findViewById(R.id.Let_start_i);
        Unit1 = findViewById(R.id.UNIT1_practice_i);


        Button_i.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Здесь код, который будет выполнен при клике на No_password
                intent = new Intent(Introduction_UNIT1.this, UNIT1.class);
                startActivity(intent);
            }
        });
    }
}