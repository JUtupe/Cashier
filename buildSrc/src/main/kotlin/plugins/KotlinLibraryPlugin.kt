package plugins

import dependencies.KotlinLibraries
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.dependencies
import extensions.implementation

class KotlinLibraryPlugin : Plugin<Project> {

    override fun apply(project: Project) {
        with(project) {
            applyPlugins()
            dependenciesConfig()
        }
    }

    private fun Project.applyPlugins() {
        plugins.run {
            apply("kotlin")
        }
    }

    private fun Project.dependenciesConfig() {
        dependencies {
            implementation(KotlinLibraries.kotlin)
        }
    }
}