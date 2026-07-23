package com.nexus.buildlogic

import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.api.plugins.JavaLibraryPlugin

class LibraryPlugin implements Plugin<Project> {

    @Override
    void apply(Project project) {

        project.pluginManager.apply(JavaConventionPlugin)
        project.pluginManager.apply(JavaLibraryPlugin)

    }
}