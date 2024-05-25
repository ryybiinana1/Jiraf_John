package ru.mirea_.rybina_iboldova.jiraf_john;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.yandex.mapkit.Animation;
import com.yandex.mapkit.MapKitFactory;
import com.yandex.mapkit.geometry.Point;
import com.yandex.mapkit.map.CameraPosition;
import com.yandex.mapkit.mapview.MapView;

import ru.mirea_.rybina_iboldova.jiraf_john.databinding.ActivityMainBinding;

public class Pogoda extends AppCompatActivity {
    private ActivityMainBinding binding;
    private MapView mapView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        MapKitFactory.setApiKey("00ccc9a4-5709-40a2-bde6-be84e83430e4");
        MapKitFactory.initialize(this);
        //binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(R.layout.activity_pogoda);
        //mapView = binding.mapview;
        mapView = findViewById(R.id.mapview);
        mapView.getMap().move(
                new CameraPosition(new Point(55.751574, 37.573856), 11.0f, 0.0f, 0.0f),
                new Animation(Animation.Type.SMOOTH, 0),
                null);
    }

    @Override
    protected void onStart() {
        super.onStart();
        mapView.onStart(); // Передача события onStart в MapView
        MapKitFactory.getInstance().onStart(); // Передача события onStart в MapKitFactory
    }

    @Override
    protected void onStop() {
        super.onStop();
        mapView.onStop(); // Передача события onStop в MapView
        MapKitFactory.getInstance().onStop(); // Передача события onStop в MapKitFactory
    }
}



/*
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_pogoda);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}

 */


