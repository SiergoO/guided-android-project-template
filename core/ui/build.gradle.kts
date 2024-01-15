plugins {
    alias(libs.plugins.cleanlibrary.android.library)
    alias(libs.plugins.cleanlibrary.android.library.compose)
}

android {
    namespace = "com.template.cleanlibrary.core.ui"
}

dependencies {
    implementation(libs.orbit.core)
    implementation(libs.viewmodel.ktx)
}