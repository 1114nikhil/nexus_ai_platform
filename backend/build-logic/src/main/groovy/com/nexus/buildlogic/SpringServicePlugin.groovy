package com.nexus.buildlogic

import org.gradle.api.Plugin
import org.gradle.api.Project

class SpringServicePlugin implements Plugin<Project> {

    @Override
    void apply(Project project) {

        project.pluginManager.apply(JavaConventionPlugin)

        project.pluginManager.apply("org.springframework.boot")

        project.pluginManager.apply("io.spring.dependency-management")

        project.dependencies.add(
                "implementation",
                "org.springframework.boot:spring-boot-starter"
        )

        project.dependencies.add(
                "testImplementation",
                "org.springframework.boot:spring-boot-starter-test"
        )
    }
}