package ru.mirea_.rybina_iboldova.jiraf_john;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;



public class SignUpActivity extends AppCompatActivity {

    private TextView No_password1;
    private Intent intent;
    private TextView User_name;
    private TextView Password;
    private ConstraintLayout Button_autorizaton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        No_password1 = findViewById(R.id.no_password1);
        No_password1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Здесь код, который будет выполнен при клике на No_password
                intent = new Intent(SignUpActivity.this, MainActivity1.class);
                startActivity(intent);
            }
        });
        User_name = findViewById(R.id.user_name);
        Password = findViewById(R.id.password);
        Button_autorizaton = findViewById(R.id.button_autorizaton);

    }
}