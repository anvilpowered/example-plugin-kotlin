@file:Suppress("UnstableApiUsage")

dependencyResolutionManagement {
    repositories {
        mavenLocal()
        mavenCentral()
        maven("https://oss.sonatype.org/content/repositories/snapshots/")
        maven("https://repo.papermc.io/repository/maven-public/")
    }
}

rootProject.name = "example-plugin-kotlin"

sequenceOf(
    "core",
    "paper",
    "sponge",
    "velocity",
).forEach {
    val project = ":${rootProject.name}-$it"
    include(project)
    project(project).projectDir = file(it.replace('-', '/'))
}
