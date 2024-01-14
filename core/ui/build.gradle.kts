plugins {
    alias(libs.plugins.cleanlibrary.android.library)
    alias(libs.plugins.cleanlibrary.android.library.compose)
}

android {
    namespace = AndroidConfig.Project.NAMESPACE + ".core.ui"
}

dependencies {
    implementation(libs.bundles.di)

    implementation(libs.orbit.core)
}