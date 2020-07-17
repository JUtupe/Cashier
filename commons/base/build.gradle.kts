import dependencies.AndroidLibraries
import dependencies.Libraries
import extensions.kapt

plugins {
    id("common-android-library")
    kotlin("kapt")
}

dependencies {
    implementation(AndroidLibraries.appCompat)
    implementation(Libraries.rxJava)

    kapt(AndroidLibraries.databinding)
}