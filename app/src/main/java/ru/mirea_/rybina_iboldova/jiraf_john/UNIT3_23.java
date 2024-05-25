package ru.mirea_.rybina_iboldova.jiraf_john;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class UNIT3_23 extends AppCompatActivity {
    private Button button2_unit1_22, button_answer_u1_2;
    private Intent intent;
    private TextView editText_unit1_22;
    private boolean IsAnswered = false;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_unit3_23);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        button2_unit1_22 = findViewById(R.id.button2_unit1_22);
        editText_unit1_22 = findViewById(R.id.editText_unit1_22);
        button_answer_u1_2 = findViewById(R.id.button_answer_u1_2);


        button_answer_u1_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String answer = editText_unit1_22.getText().toString().trim();
                if (answer.equals("I never go to the cinema")|| answer.equals("i never go to the cinema") || answer.equals("I never go to the cinema.") ||answer.equals("i never go to the cinema."))  {
                    GlobalState globalState = GlobalState.getInstance();
                    globalState.addMyAnswers();
                    Toast.makeText(UNIT3_23.this, "Correct!", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(UNIT3_23.this, "Incorrect!", Toast.LENGTH_SHORT).show();
                }
                IsAnswered = true;
            }
        });

        button2_unit1_22.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (IsAnswered) {
                    GlobalState globalState = GlobalState.getInstance();
                    globalState.addMyAnswers();
                // Здесь код, который будет выполнен при клике на button4_unit1_1
                intent = new Intent(UNIT3_23.this, UNIT3_24.class);
                startActivity(intent);}
                else {
                    Toast.makeText(UNIT3_23.this, "Need answer!", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }
}