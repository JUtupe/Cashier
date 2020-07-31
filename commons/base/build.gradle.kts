import dependencies.Libraries
import extensions.kapt

plugins {
    id("common-android-library")
    kotlin("kapt")
}

dependencies {
    //implementation(Libraries.appCompat)

    kapt(Libraries.databinding)
}