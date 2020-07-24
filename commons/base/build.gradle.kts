import dependencies.AndroidLibraries
import dependencies.Libraries
import extensions.kapt

plugins {
    id("common-android-library")
    kotlin("kapt")
}

dependencies {
    implementation(AndroidLibraries.appCompat)
    implementation(AndroidLibraries.recyclerview)

    //implementation(Libraries.coroutines)
    //implementation(Libraries.coroutinesAndroid)

    kapt(AndroidLibraries.databinding)
}