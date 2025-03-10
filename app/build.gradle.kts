plugins {
    alias(libs.plugins.android.application)
}

android {
    namespace = "com.example.tarea2sag"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.example.tarea2sag"
        minSdk = 24
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }

}

dependencies {
    implementation (libs.kotlin.stdlib.jdk8)
    implementation (libs.appcompat.v161)
    implementation (libs.material.v190)
    implementation (libs.cardview)
    implementation (libs.recyclerview)
    implementation (libs.recyclerview.selection)
    implementation(libs.appcompat)
    implementation(libs.material)
    implementation(libs.activity)
    implementation(libs.constraintlayout)
    testImplementation(libs.junit)
    androidTestImplementation(libs.ext.junit)
    androidTestImplementation(libs.espresso.core)
}