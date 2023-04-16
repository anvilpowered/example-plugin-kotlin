dependencies {
    implementation(project(":example-plugin-kotlin-core"))
    implementation(libs.kbrig.brigadier)
    compileOnly(libs.paper)
}
