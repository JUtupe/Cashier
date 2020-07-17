package plugins

import com.android.build.gradle.BaseExtension
import extensions.implementation
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.dependencies
import dependencies.*

class AndroidDynamicFeaturePlugin : Plugin<Project> {

    private val Project.android: BaseExtension
        get() = extensions.findByName("android") as? BaseExtension
            ?: error("Not an Android module: $name")

    override fun apply(project: Project) =
        with(project) {
            applyPlugins()
            androidConfig()
            dependenciesConfig()
        }

    private fun Project.applyPlugins() {
        plugins.run {
            apply("com.android.dynamic-feature")
            apply("kotlin-android")
            apply("kotlin-android-extensions")
        }
    }

    private fun Project.androidConfig() {
        android.run {
            compileSdkVersion(Versions.compileSdk)

            defaultConfig {
                minSdkVersion(Versions.minSdk)
                targetSdkVersion(Versions.targetSdk)

                versionCode = Releases.versionCode
                versionName = Releases.versionName

                testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
            }

            buildTypes {
                getByName("debug") {
                    isMinifyEnabled = false
                }
            }

            buildFeatures.dataBinding = true
        }
    }

    private fun Project.dependenciesConfig() {
        dependencies {
            implementation(KotlinLibraries.kotlin)
            implementation(Libraries.timber)

            implementation(Libraries.koin)
            implementation(Libraries.koinViewModel)

            implementation(AndroidLibraries.appCompat)
        }
    }
}