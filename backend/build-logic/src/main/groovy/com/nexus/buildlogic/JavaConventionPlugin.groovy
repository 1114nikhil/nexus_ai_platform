package com.nexus.buildlogic
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.api.plugins.JavaPlugin
import org.gradle.api.plugins.JavaPluginExtension
import org.gradle.api.tasks.testing.Test
import org.gradle.jvm.toolchain.JavaLanguageVersion

class JavaConventionPlugin implements Plugin<Project> {

    @Override
    void apply(Project project) {

        project.pluginManager.apply(JavaPlugin)

        JavaPluginExtension java =
                project.extensions.getByType(JavaPluginExtension)

        java.toolchain.languageVersion.set(
                JavaLanguageVersion.of(21)
        )

        project.tasks.withType(Test).configureEach {

            useJUnitPlatform()
        }
    }
}