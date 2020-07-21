import dependencies.AndroidLibraries

plugins {
    id("common-android-library")
    kotlin("kapt")
}

dependencies {
    implementation(project(":commons:base"))

    implementation(AndroidLibraries.appCompat)
    implementation(AndroidLibraries.constraintLayout)
    implementation(AndroidLibraries.material)

    implementation(AndroidLibraries.navigationFragment)
    implementation(AndroidLibraries.navigation)
    implementation("androidx.legacy:legacy-support-v4:1.0.0")

    kapt(AndroidLibraries.databinding)
}