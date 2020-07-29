import dependencies.*
import extensions.kapt

plugins {
    id("common-android-library")
    kotlin("kapt")
}

dependencies {
    implementation(Libraries.room)
    implementation(Libraries.roomKtx)
    implementation(Libraries.coroutines)

    implementation(Libraries.paging)

    kapt(Libraries.roomCompiler)
}