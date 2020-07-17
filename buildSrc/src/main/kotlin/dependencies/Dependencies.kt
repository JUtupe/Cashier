package dependencies

object ApplicationId {
    const val id = "pl.jutupe.cashier"
}

object Releases {
    const val versionCode = 1
    const val versionName = "0.1"
}

object Versions {
    const val minSdk = 21
    const val compileSdk = 29
    const val targetSdk = 29
    const val buildToolsVersion = "29.0.2"
}

object Libraries {
    const val gradle = "com.android.tools.build:gradle:4.0.1"
    const val gradlePlugin = "org.jetbrains.kotlin:kotlin-gradle-plugin:1.3.72"

    const val timber = "com.jakewharton.timber:timber:4.7.1"

    const val koin = "org.koin:koin-android:2.0.1"
    const val koinViewModel = "org.koin:koin-android-viewmodel:2.0.1"

    const val rxJava = "io.reactivex.rxjava2:rxjava:2.2.10"
    const val rxKotlin = "io.reactivex.rxjava2:rxkotlin:2.3.0"
    const val rxAndroid = "io.reactivex.rxjava2:rxandroid:2.1.1"
}

object AndroidLibraries {
    const val appCompat = "androidx.appcompat:appcompat:1.1.0"
    const val recyclerview = "androidx.recyclerview:recyclerview:1.1.0"
    const val cardview = "androidx.cardview:cardview:1.0.0"

    const val material = "com.google.android.material:material:1.0.0"
    const val constraintLayout = "androidx.constraintlayout:constraintlayout:2.0.0-alpha2"

    const val safeArgsPlugin = "android.arch.navigation:navigation-safe-args-gradle-plugin:1.0.0"

    const val databinding = "androidx.databinding:databinding-compiler:4.0.1"
    const val navigationFragment = "androidx.navigation:navigation-fragment-ktx:2.2.0-alpha03"
    const val navigation = "androidx.navigation:navigation-ui-ktx:2.2.0-alpha03"
}

object KotlinLibraries {
    const val kotlin = "org.jetbrains.kotlin:kotlin-stdlib-jdk7:1.3.72"
}

object TestLibraries {
    const val junit = "junit:junit:4.12"
    const val testRunner = "com.android.support.test:runner:1.0.2"
    const val mockk = "io.mockk:mockk:1.9"
    const val mockWebServer = "com.squareup.okhttp3:mockwebserver:4.2.1"
}
