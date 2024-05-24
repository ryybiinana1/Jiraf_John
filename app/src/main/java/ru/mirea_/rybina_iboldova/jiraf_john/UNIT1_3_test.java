package ru.mirea_.rybina_iboldova.jiraf_john;


import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;


import androidx.appcompat.app.AppCompatActivity;
import android.graphics.Path;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class UNIT1_3_test extends AppCompatActivity {
    private Drawing_View lineView;
    private Button checkButton;
    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_unit1_3_test);

        lineView = findViewById(R.id.drawing_area_test);
        checkButton = findViewById(R.id.question_text_test);
        /*checkButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkAnswers();
            }
        });*/
    }

    /*private void checkAnswers() {
        // Получаем список соединений пользовательских линий
        List<Path> userPaths = lineView.getPaths();

        // Предположим, что правильные соединения заданы заранее
        List<Path> correctPaths = getCorrectPaths();

        // Проверяем, соответствует ли каждая пользовательская линия хотя бы одному правильному соединению
        boolean allCorrect = true;
        for (Path userPath : userPaths) {
            boolean pathCorrect = false;
            for (Path correctPath : correctPaths) {
                if (pathsMatch(userPath, correctPath)) {
                    pathCorrect = true;
                    break;
                }
            }
            if (!pathCorrect) {
                allCorrect = false;
                break;
            }
        }

        // Выводим сообщение о результате проверки
        if (allCorrect) {
            Toast.makeText(UNIT1_3_test.this, "Все соединения верные!", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(UNIT1_3_test.this, "Некоторые соединения неверные!", Toast.LENGTH_SHORT).show();
        }
    }

    // Метод для сравнения двух линий
    private boolean pathsMatch(Path path1, Path path2) {
        // Здесь нужно реализовать логику сравнения двух линий
        // Например, можно использовать методы Path.contains и Path.approximate
        // для проверки, находится ли одна линия внутри другой
        // В этом примере мы просто сравниваем hashCode линий для демонстрации
        return path1.hashCode() == path2.hashCode();
    }

    // Метод, возвращающий список правильных соединений
    private List<Path> getCorrectPaths() {
        // Здесь нужно вернуть список правильных соединений
        // В этом примере возвращаем пустой список
        return new ArrayList<>();
    }*/
}

/*public class UNIT1_3_test extends AppCompatActivity {

    private DrawingView drawingView;
    private Button checkButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_unit1_3_test);

        drawingView = new DrawingView(this);
        View view = findViewById(R.id.drawing_area_test);
        LinearLayout drawingArea;
        if (view instanceof LinearLayout) {
            drawingArea = (LinearLayout) view;
        } else {
            // Обработка случая, когда вид не является LinearLayout
            // Можно выбросить исключение или выполнить другую логику
            throw new ClassCastException("View with id R.id.drawing_area_test is not a LinearLayout");
        }
        @SuppressLint("WrongViewCast") LinearLayout drawingArea = findViewById(R.id.drawing_area_test);
        drawingArea.addView(drawingView);

        checkButton = new Button(this);
        checkButton.setText("Check Answers");
        checkButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkAnswers();
            }
        });
        drawingArea.addView(checkButton);
    }

    private void checkAnswers() {
        // Логика проверки правильных соединений.
        // Пример:
        // правильные пары (x1, y1, x2, y2)
        float[][] correctPairs = {
                {100, 200, 800, 200},
                {100, 400, 800, 400},
                {100, 600, 800, 600}
        };

        boolean allCorrect = true;
        for (DrawingView.Line line : drawingView.getLines()) {
            boolean correct = false;
            for (float[] pair : correctPairs) {
                if (lineMatches(line, pair)) {
                    correct = true;
                    break;
                }
            }
            if (!correct) {
                allCorrect = false;
                break;
            }
        }

        if (allCorrect) {
            Toast.makeText(UNIT1_3_test.this, "Все ответы правильные!", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(UNIT1_3_test.this, "Некоторые ответы неправильные!", Toast.LENGTH_SHORT).show();
        }
    }

    private boolean lineMatches(DrawingView.Line line, float[] pair) {
        return (line.startX == pair[0] && line.startY == pair[1] && line.stopX == pair[2] && line.stopY == pair[3])
                || (line.startX == pair[2] && line.startY == pair[3] && line.stopX == pair[0] && line.stopY == pair[1]);
    }


}*/