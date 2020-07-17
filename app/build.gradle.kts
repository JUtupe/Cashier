import dependencies.AndroidLibraries
import dependencies.ApplicationId
import dependencies.Versions
import dependencies.Libraries
import dependencies.KotlinLibraries
import dependencies.Releases

plugins {
    id("com.android.application")
    kotlin("android")
    kotlin("android.extensions")
}

android {
    compileSdkVersion(Versions.compileSdk)

    defaultConfig {
        applicationId = ApplicationId.id

        minSdkVersion(Versions.minSdk)
        targetSdkVersion(Versions.targetSdk)

        versionCode = Releases.versionCode
        versionName = Releases.versionName

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
        }
    }

    android.buildFeatures.dataBinding = true
}

dependencies {
    implementation(fileTree(mapOf("dir" to "libs", "include" to listOf("*.jar"))))
    implementation(KotlinLibraries.kotlin)

    implementation(project(":core"))
    implementation(project(":features:home"))

    implementation(AndroidLibraries.appCompat)

    implementation(Libraries.timber)
    implementation(Libraries.koin)
}