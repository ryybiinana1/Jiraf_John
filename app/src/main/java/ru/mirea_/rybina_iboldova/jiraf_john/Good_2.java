package ru.mirea_.rybina_iboldova.jiraf_john;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Good_2 extends AppCompatActivity {
    private Button button_go_to_menu;
    private Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_good);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        button_go_to_menu = findViewById(R.id.button_go_to_menu);

        button_go_to_menu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Здесь код, который будет выполнен при клике на button4_unit1_1
                intent = new Intent(Good_2.this, MainMenu.class);
                startActivity(intent);
            }
        });
    }
}