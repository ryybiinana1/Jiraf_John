package ru.mirea_.rybina_iboldova.jiraf_john;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainMenu extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main_menu);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // Найдем кнопку по ее id
        Button map = findViewById(R.id.bbb_carta);
        Button button1 = findViewById(R.id.MainMenu_button1);
        Button MainMenu_button2 = findViewById(R.id.MainMenu_button2);
        Button MainMenu_button3 = findViewById(R.id.MainMenu_button3);

        InternalStorage storage = new InternalStorage(this);

        MainMenu_button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Создаем Intent для перехода на Activity Theory1
                Intent intent = new Intent(MainMenu.this, Theory2.class);
                // Запускаем Activity Theory1
                startActivity(intent);

                GlobalState globalState = GlobalState.getInstance();
                globalState.setGlobalVariables(7);
            }
        });
        map.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                // Создаем Intent для перехода на Activity Theory1
                Intent intent = new Intent(MainMenu.this, Pogoda.class);
                // Запускаем Activity Theory1
                startActivity(intent);

                GlobalState globalState = GlobalState.getInstance();
                globalState.setGlobalVariables(7);
            }
        });


        if (storage.checkUnitCompletion(1)) {
            button1.setBackgroundColor(Color.GREEN);
        } else {
            button1.setBackgroundColor(Color.RED);
        }
        if (storage.checkUnitCompletion(2)) {
            MainMenu_button2.setBackgroundColor(Color.GREEN);
        } else {
            MainMenu_button2.setBackgroundColor(Color.RED);
        }
        if (storage.checkUnitCompletion(3)) {
            MainMenu_button3.setBackgroundColor(Color.GREEN);
        } else {
            MainMenu_button3.setBackgroundColor(Color.RED);
        }
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Создаем Intent для перехода на Activity Theory1
                Intent intent = new Intent(MainMenu.this, Theory1.class);
                // Запускаем Activity Theory1
                startActivity(intent);
            }
        });
        MainMenu_button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Создаем Intent для перехода на Activity Theory1
                Intent intent = new Intent(MainMenu.this, Theory3.class);
                // Запускаем Activity Theory1
                startActivity(intent);
            }
        });
    }
}
