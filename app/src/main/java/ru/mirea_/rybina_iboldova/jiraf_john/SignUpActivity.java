package ru.mirea_.rybina_iboldova.jiraf_john;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import java.sql.PreparedStatement;
import java.sql.SQLException;


public class SignUpActivity extends AppCompatActivity {

    private TextView No_password1;
    private Intent intent;
    private TextView User_name;
    private TextView Password;
    private ConstraintLayout Button_autorizaton;
    private PostgresDbHelper dbHelper;

    private PostgresDbHelper postgresDbHelper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        No_password1 = findViewById(R.id.no_password1);
        No_password1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Здесь код, который будет выполнен при клике на No_password
//                intent = new Intent(SignUpActivity.this, MainActivity1.class);
//                startActivity(intent);
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        String username = "test_user";
                        String password = "secure_password";
                        String hashedPassword = PostgresDbHelper.hashPassword(password);

                        // Insert the new user into the database
                        String insertUserQuery = "INSERT INTO users (username, password) VALUES (?, ?)";
                        try (PreparedStatement pstmt = dbHelper.getConnection().prepareStatement(insertUserQuery)) {
                            pstmt.setString(1, username);
                            pstmt.setString(2, hashedPassword);
                            pstmt.executeUpdate();
                        } catch (SQLException e) {
                            e.printStackTrace();
                        }

                        // Example usage of the auth method
                        boolean userExists = dbHelper.auth(username, password);

                        // Update UI on the main thread
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                if (userExists) {
//                                    Toast.makeText(MainActivity.this, "Authentication successful!", Toast.LENGTH_SHORT).show();
                                    System.out.println("USER EXIST");
                                } else {
//                                    Toast.makeText(MainActivity.this, "Authentication failed.", Toast.LENGTH_SHORT).show();
                                    System.out.println("USER NOT EXIST");
                                }
                            }
                        });

                        dbHelper.close();
                    }
                }).start();
            }
        });
        User_name = findViewById(R.id.user_name);
        Password = findViewById(R.id.password);
        Button_autorizaton = findViewById(R.id.button_autorizaton);


        setContentView(R.layout.activity_main);

        dbHelper = new PostgresDbHelper();

        // Example usage of creating a user with a hashed password


    }
    @Override
    protected void onDestroy() {
        super.onDestroy();
        dbHelper.close();
    }
}