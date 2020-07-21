import dependencies.*
import extensions.kapt

plugins {
    id("common-android-library")
    kotlin("kapt")
}

dependencies {
    implementation(Libraries.rxJava)
    implementation(Libraries.room)
    implementation(Libraries.roomRxJava)

    kapt(Libraries.roomCompiler)
}