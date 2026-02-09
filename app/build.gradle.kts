plugins {
    id("com.android.application")
}

android {
    namespace = "com.example.eventopia"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.example.eventopia"
        minSdk = 24
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
        }
    }

    // Proje Java, bu yüzden sadece Java ayarları yeterli
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
}

dependencies {

    // Android UI
    implementation("androidx.appcompat:appcompat:1.6.1")
    implementation("com.google.android.material:material:1.8.0")
    implementation("androidx.constraintlayout:constraintlayout:2.1.4")

    // Sadece QR ÜRETME için ZXing core
    implementation("com.google.zxing:core:3.5.0")
}
