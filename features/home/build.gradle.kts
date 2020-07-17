import dependencies.AndroidLibraries

plugins {
    id("common-android-library")
    id("kotlin-android")
}

dependencies {
    implementation(project(":commons:base"))

    implementation(AndroidLibraries.appCompat)
    implementation(AndroidLibraries.constraintLayout)
    implementation(AndroidLibraries.material)

    implementation(AndroidLibraries.navigationFragment)
    implementation(AndroidLibraries.navigation)
    implementation("androidx.legacy:legacy-support-v4:1.0.0")
}