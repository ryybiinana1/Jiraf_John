package ru.mirea_.rybina_iboldova.jiraf_john;

import android.app.Application;
import com.yandex.mapkit.MapKitFactory;

public class App extends Application {
    private final String MAPKIT_API_KEY = "00ccc9a4-5709-40a2-bde6-be84e83430e4";

    @Override
    public void onCreate() {
        super.onCreate();
        // Установите ключ API перед вызовом метода initialize
        MapKitFactory.setApiKey(MAPKIT_API_KEY);
    }
}
