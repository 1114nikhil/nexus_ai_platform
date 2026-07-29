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
                "implementation",
                "org.springframework.boot:spring-boot-starter-validation"
        )

        project.dependencies.add(
                "testImplementation",
                "org.springframework.boot:spring-boot-starter-test"
        )
        project.dependencies.add(
                "compileOnly",
                "org.projectlombok:lombok"
        )

        project.dependencies.add(
                "annotationProcessor",
                "org.projectlombok:lombok"
        )

        project.dependencies.add(
                "testCompileOnly",
                "org.projectlombok:lombok"
        )

        project.dependencies.add(
                "testAnnotationProcessor",
                "org.projectlombok:lombok"
        )
        project.dependencies.add(
                "implementation",
                "org.springframework.boot:spring-boot-starter-actuator"
        )
//we need to remove once add the application class
//        project.tasks.named("bootJar") {
//            enabled = false
//        }
//
//        project.tasks.named("jar") {
//            enabled = true
//        }
    }
}