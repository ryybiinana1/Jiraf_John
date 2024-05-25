plugins {
    id("com.android.application")
}

android {
    namespace = "ru.mirea_.rybina_iboldova.jiraf_john"
    compileSdk = 34

    defaultConfig {
        applicationId = "ru.mirea_.rybina_iboldova.jiraf_john"
        minSdk = 26
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    buildFeatures {
        viewBinding = true
    }
    buildFeatures {
        dataBinding = true;
    }
}

dependencies {
    implementation ("com.yandex.android:maps.mobile:4.3.1-full")
    //implementation ("com.squareup.sqlite:sqlite:2.2.0")
    //яндекс
    //implementation("com.yandex.android:maps.mobile:4.3.1-full")
    implementation ("org.xerial:sqlite-jdbc:3.36.0.3")
    implementation ("org.postgresql:postgresql:42.2.20")
    implementation ("org.mindrot:jbcrypt:0.4")
    implementation("androidx.appcompat:appcompat:1.6.1")
    implementation("com.google.android.material:material:1.12.0")
    implementation("androidx.constraintlayout:constraintlayout:2.1.4")
    implementation("androidx.activity:activity:1.9.0")
    implementation("androidx.annotation:annotation:1.8.0")
    implementation("androidx.lifecycle:lifecycle-livedata-ktx:2.8.0")
    implementation("androidx.lifecycle:lifecycle-viewmodel-ktx:2.8.0")
    implementation("androidx.navigation:navigation-fragment:2.7.7")
    implementation("androidx.navigation:navigation-ui:2.7.7")
    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")

}


