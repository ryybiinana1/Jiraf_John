package ru.mirea_.rybina_iboldova.jiraf_john;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import org.postgresql.core.Tuple;


public class SignUpActivity extends AppCompatActivity {

    private TextView No_password1;
    private Intent intent;
    private TextView User_name;
    private TextView Password;
    private ConstraintLayout Button_autorizaton;


    @SuppressLint("CutPasteId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        No_password1 = findViewById(R.id.password_sign_up);
        User_name = findViewById(R.id.user_name_sign_up);
        Password = findViewById(R.id.password_sign_up);


        InternalStorage storage = new InternalStorage(this);
        No_password1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Здесь код, который будет выполнен при клике на No_password
//                intent = new Intent(SignUpActivity.this, MainActivity1.class);
//                startActivity(intent);
                String username = User_name.getText().toString();
                String password = Password.getText().toString();
                if (User_name.getText().length() > 5 || Password.getText().length() > 5){
                    storage.createUser(username, password);
                    boolean isLoggedIn = storage.loginUser(username, password);
                    if (isLoggedIn) {
                        System.out.println("Login successful!");
                        intent = new Intent(SignUpActivity.this, MainMenu.class);
                        startActivity(intent);
                    } else {
                        System.out.println("Invalid username or password.");
                    }
                } else {
                    Toast.makeText(SignUpActivity.this, "Login or password aren't more or equal 5 length", Toast.LENGTH_SHORT).show();
                }

            }
        });
        Button_autorizaton = findViewById(R.id.button_autorizaton);
        // Example usage of creating a user with a hashed password
        Button_autorizaton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Здесь код, который будет выполнен при клике на No_password
//                intent = new Intent(SignUpActivity.this, MainActivity1.class);
//                startActivity(intent);
                String username = User_name.getText().toString();
                String password = Password.getText().toString();
//                if (User_name.getText().length() >= 5 || Password.getText().length() >= 5){
                storage.createUser(username, password);
                boolean isLoggedIn = storage.loginUser(username, password);
                if (isLoggedIn) {
                    System.out.println("Login successful!");
                    intent = new Intent(SignUpActivity.this, MainMenu.class);
                    startActivity(intent);
                } else {
                    System.out.println("Invalid username or password.");
                    Toast.makeText(SignUpActivity.this, "Invalid username or password.", Toast.LENGTH_SHORT).show();
                }
//                } else {
//                    Toast.makeText(SignUpActivity.this, "Login or password aren't more or equal 5 length", Toast.LENGTH_SHORT).show();
//                }

            }
        });

    }
}