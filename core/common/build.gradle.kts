plugins {
    alias(libs.plugins.cleanlibrary.android.library)
    alias(libs.plugins.cleanlibrary.android.library.compose)
    alias(libs.plugins.cleanlibrary.android.koin)
}

android {
    namespace = "com.template.cleanlibrary.core.common"
}

dependencies {
    implementation(libs.orbit.core)
}