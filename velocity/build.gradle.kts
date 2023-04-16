plugins {
    kotlin("kapt")
}

dependencies {
    implementation(project(":example-plugin-kotlin-core"))
    implementation(libs.kbrig.brigadier)
    compileOnly(libs.velocity)
    kapt(libs.velocity)
}
