package ru.mirea_.rybina_iboldova.jiraf_john;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;


public class MainActivity1 extends AppCompatActivity {
    private TextView No_password;
    private Intent intent;
    private TextView User_name;
    private TextView Password;
    private ConstraintLayout Button_autorizaton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        No_password = findViewById(R.id.no_password);
        User_name = findViewById(R.id.user_name);
        Password = findViewById(R.id.password);
        Button_autorizaton = findViewById(R.id.button_autorizaton);

        Button_autorizaton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Здесь код, который будет выполнен при клике на No_password
                intent = new Intent(MainActivity1.this, MainMenu.class);
                startActivity(intent);
            }
        });
        No_password.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Здесь код, который будет выполнен при клике на No_password
                intent = new Intent(MainActivity1.this, SignUpActivity.class);
                startActivity(intent);
            }
        });
    }
}