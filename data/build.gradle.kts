plugins {
    id(Plugins.AGP.library)
    id(Plugins.Kotlin.android)
}

android {
    namespace = "com.example.data"
    compileSdk = AppConfig.comparableSdk

    defaultConfig {
        minSdk =  AppConfig.minSdk
        targetSdk = AppConfig.targetSdk

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        consumerProguardFiles("consumer-rules.pro")
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
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
}

dependencies {
    implementation(Dependencies.UI.core)
    implementation(Dependencies.UI.appcompat)
    implementation(Dependencies.UI.material)
    testImplementation(Dependencies.UI.junit)
    androidTestImplementation(Dependencies.UI.test)
    androidTestImplementation(Dependencies.UI.espressoc)
}