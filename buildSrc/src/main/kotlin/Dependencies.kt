object Plugins {

    object AGP{

        const val application ="com.android.application"
        const val library =  "com.android.library"
    }

    object Kotlin{
        const val android= "org.jetbrains.kotlin.android"
        const val jvm =  "org.jetbrains.kotlin.jvm"
        const val kapt = "kotlin-kapt"
    }

    object DaggerHilt{
        const val hilt = "com.google.dagger.hilt.android"
    }

    object MyApplication{
       const val My ="My Application"
        const val app = ":app"
        const val data = ":data"
        const val domain = ":domain"
    }
}

object Dependencies {

    object UI {
        const val core = "androidx.core:core-ktx:${Versions.core}"
        const val appcompat = "androidx.appcompat:${Versions.appcompat}"
        const val material = "com.google.android.material:${Versions.material}"
        const val constraint = "androidx.constraintlayout:${Versions.constraint}"
        const val junit = "junit:junit:${Versions.junit}"
        const val test = "androidx.test.ext:junit:${Versions.test}"
        const val espresso = "androidx.test.espresso:${Versions.espresso}"
    }

    object Room {

        const val runtime = "androidx.room:room-runtime:${Versions.room}"
        const val ktx = "androidx.room:room-ktx:${Versions.room}"
        const val room = "androidx.room:room-compiler:${Versions.room}"
    }

    object DaggerHilt {

        const val hilt = "com.google.dagger:hilt-android:${Versions.hilt}"
        const val compiler = "com.google.dagger:hilt-compiler:${Versions.hilt}"
    }

    object Coroutine {
        const val coroutines =
            "org.jetbrains.kotlinx:kotlinx-coroutines-android:${Versions.coroutines}"
        const val viewmodel = "androidx.lifecycle:lifecycle-viewmodel-ktx:${Versions.viewmodel}"
        const val viewbindingpropertydelegate =
            "com.github.kirich1409:viewbindingpropertydelegate-full:${Versions.viewbindingpropertydelegate}"
    }

}

object Versions {
    const val core = "1.9.0"
    const val appcompat = "1.6.1"
    const val material = "1.8.0"
    const val constraint = "2.1.4"
    const val junit = "4.13.2"
    const val test = "1.1.5"
    const val espresso = "3.5.1"
    const val room = "2.5.0"
    const val hilt = "2.44"
    const val coroutines = "1.6.4"
    const val viewmodel = "2.6.0"
    const val viewbindingpropertydelegate = "1.5.8"

    const val espressoc = "3.4.0"
    const val AGP = "7.3.1"
    const val library = "7.4.2"
    const val android = "1.7.10"
    const val kotlin = "1.8.0"
}