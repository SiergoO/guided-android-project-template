plugins {
    alias(libs.plugins.cleanlibrary.android.library)
    id(libs.plugins.serialization.get().pluginId)
}

android {
    namespace = "com.template.cleanlibrary.core.network"
}

dependencies {
    api(projects.core.common)

    implementation(libs.bundles.ktor)
    implementation(libs.serialization.json)
    implementation(libs.timber)
}