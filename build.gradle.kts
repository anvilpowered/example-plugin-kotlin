plugins {
    alias(libs.plugins.kotlin.jvm)
    alias(libs.plugins.ktlint)
    alias(libs.plugins.shadow)
}

val projectVersion = file("version").readLines().first()

allprojects {
    apply(plugin = "org.jetbrains.kotlin.jvm")
    apply(plugin = "org.jlleitschuh.gradle.ktlint")
    apply(plugin = "java-library")
    group = "org.example"
    version = projectVersion
    kotlin {
        jvmToolchain(17)
        target.compilations.all {
            kotlinOptions.freeCompilerArgs += listOf(
                "-opt-in=kotlin.RequiresOptIn",
                "-Xcontext-receivers",
            )
        }
    }
}

dependencies {
    runtimeOnly(project(":example-plugin-kotlin-paper"))
    runtimeOnly(project(":example-plugin-kotlin-sponge"))
    runtimeOnly(project(":example-plugin-kotlin-velocity"))
}
