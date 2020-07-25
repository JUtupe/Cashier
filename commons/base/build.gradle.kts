import dependencies.Libraries
import extensions.kapt

plugins {
    id("common-android-library")
    kotlin("kapt")
}

dependencies {
    implementation(Libraries.appCompat)
    implementation(Libraries.recyclerview)

    //implementation(Libraries.coroutines)
    //implementation(Libraries.coroutinesAndroid)

    kapt(Libraries.databinding)
}