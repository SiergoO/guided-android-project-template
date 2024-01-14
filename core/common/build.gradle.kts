plugins {
    alias(libs.plugins.cleanlibrary.android.library)
    alias(libs.plugins.cleanlibrary.android.library.compose)
    alias(libs.plugins.cleanlibrary.android.koin)
}

android {
    namespace = AndroidConfig.Project.NAMESPACE + ".core.common"
}

dependencies {
    implementation(libs.orbit.core)
}