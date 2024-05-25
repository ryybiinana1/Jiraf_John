package ru.mirea_.rybina_iboldova.jiraf_john;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import org.sqlite.SQLiteConnection;

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

        No_password = findViewById(R.id.no_password_main);
        User_name = findViewById(R.id.user_name_main);
        Password = findViewById(R.id.password_main);
        Button_autorizaton = findViewById(R.id.button_autorizaton_main);

        InternalStorage storage = new InternalStorage(this);

        Button_autorizaton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String username = User_name.getText().toString();
                String password = Password.getText().toString();
//                storage.createUser(username, password);
                boolean isLoggedIn = storage.loginUser(username, password);
                if (isLoggedIn) {
                    System.out.println("Login successful!");
                    intent = new Intent(MainActivity1.this, MainMenu.class);
                    startActivity(intent);
                } else {
                    System.out.println("Invalid username or password.");
                    Toast.makeText(MainActivity1.this, "Invalid username or password.", Toast.LENGTH_LONG).show();
                    User_name.clearComposingText();
                    Password.clearComposingText();
                }
            }
        });

        No_password.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Здесь код, который будет выполнен при клике на ссылку "No_password"
                // Например, переход на активность регистрации
                intent = new Intent(MainActivity1.this, SignUpActivity.class);
                startActivity(intent);
            }
        });
    }
}
