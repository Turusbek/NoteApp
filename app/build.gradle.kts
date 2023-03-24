plugins {
    id(Plugins.AGP.application)
    id(Plugins.Kotlin.android)
    id(Plugins.Kotlin.kapt)
    id(Plugins.DaggerHilt.hilt)
}

android {
    namespace = "com.example.noteapp"
    compileSdk = AppConfig.comparableSdk

    defaultConfig {
        applicationId = "com.example.noteapp"
        minSdk = AppConfig.minSdk
        targetSdk = AppConfig.targetSdk
        versionCode = AppConfig.versionCode
        versionName = AppConfig.versionName

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile
                    ("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
    buildFeatures {
        viewBinding = true
    }

}

dependencies {

    implementation(Dependencies.UI.core)
    implementation(Dependencies.UI.appcompat)
    implementation(Dependencies.UI.material)
    implementation(Dependencies.UI.constraint)
    testImplementation(Dependencies.UI.junit)
    androidTestImplementation(Dependencies.UI.test)
    androidTestImplementation(Dependencies.UI.espresso)

    //room
    implementation(Dependencies.Room.runtime)
    implementation(Dependencies.Room.ktx)
    kapt(Dependencies.Room.room)

    //DI Hilt
    implementation(Dependencies.DaggerHilt.hilt)
    kapt(Dependencies.DaggerHilt.compiler)

    //Coroutine
    implementation(Dependencies.Coroutine.coroutines)
    implementation(Dependencies.Coroutine.viewmodel)
    implementation(Dependencies.Coroutine.viewbindingpropertydelegate)

}