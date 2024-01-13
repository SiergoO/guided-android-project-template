plugins {
    alias(libs.plugins.cleanlibrary.android.library)
}

android {
    namespace = AndroidConfig.Project.NAMESPACE + ".core.domain"
}

dependencies {
    implementation(libs.bundles.logging)
    implementation(libs.coroutines.core)
    implementation(libs.koin.core)
}