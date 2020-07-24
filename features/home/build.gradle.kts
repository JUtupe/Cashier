import dependencies.*

plugins {
    id("common-android-library")
    kotlin("kapt")
}

dependencies {
    implementation(project(":commons:base"))
    implementation(project(":core"))

    implementation(AndroidLibraries.appCompat)
    implementation(AndroidLibraries.constraintLayout)
    implementation(AndroidLibraries.material)

    implementation(AndroidLibraries.navigationFragment)
    implementation(AndroidLibraries.navigation)
    implementation("androidx.legacy:legacy-support-v4:1.0.0")

    implementation(Libraries.coroutines)
    implementation(Libraries.coroutinesAndroid)

    kapt(AndroidLibraries.databinding)
}