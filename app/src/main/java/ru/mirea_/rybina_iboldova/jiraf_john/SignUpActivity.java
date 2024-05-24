package ru.mirea_.rybina_iboldova.jiraf_john;

import android.content.Intent;
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
    private TextView To_main_menu1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
//        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.), (v, insets) -> {
//            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
//            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
//            return insets;
//        });

        No_password1 = findViewById(R.id.button_registration);
        To_main_menu1 = findViewById(R.id.back_to_main_1);
        To_main_menu1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Здесь код, который будет выполнен при клике на No_password
                intent = new Intent(SignUpActivity.this, MainActivity1.class);
                startActivity(intent);
            }
        });
        No_password1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Здесь код, который будет выполнен при клике на No_password
//                intent = new Intent(SignUpActivity.this, MainActivity1.class);
//                startActivity(intent);

            }
        });
        User_name = findViewById(R.id.user_name_sign_up);
        Password = findViewById(R.id.password_sign_up);
        Button_autorizaton = findViewById(R.id.button_autorizaton);



    }
}