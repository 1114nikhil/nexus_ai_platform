

import org.gradle.api.Plugin
import org.gradle.api.Project

class TestConventionsPlugin implements Plugin<Project> {

    @Override
    void apply(Project project) {

        project.dependencies.add(
                "testImplementation",
                "org.junit.jupiter:junit-jupiter"
        )

        project.dependencies.add(
                "testImplementation",
                "org.mockito:mockito-core"
        )

        project.dependencies.add(
                "testRuntimeOnly",
                "org.junit.platform:junit-platform-launcher"
        )
    }
}