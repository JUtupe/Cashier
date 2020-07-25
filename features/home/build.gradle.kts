import dependencies.*

plugins {
    id("common-android-library")
    kotlin("kapt")
}

dependencies {
    implementation(project(":commons:base"))
    implementation(project(":core"))

    implementation(Libraries.appCompat)
    implementation(Libraries.constraintLayout)
    implementation(Libraries.material)

    implementation(Libraries.navigationFragment)
    implementation(Libraries.navigation)
    implementation("androidx.legacy:legacy-support-v4:1.0.0")

    implementation(Libraries.coroutines)
    implementation(Libraries.coroutinesAndroid)

    kapt(Libraries.databinding)
}