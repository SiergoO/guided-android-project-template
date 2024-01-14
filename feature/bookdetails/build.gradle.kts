plugins {
    alias(libs.plugins.cleanlibrary.android.feature)
    alias(libs.plugins.cleanlibrary.android.library.compose)
    alias(libs.plugins.cleanlibrary.android.koin)
}

android {
    namespace = AndroidConfig.Project.NAMESPACE + ".feature.bookdetails"
}

dependencies {
    implementation(projects.core.common)
    implementation(projects.core.domain)

    implementation(libs.koin.compose)
    implementation(libs.bundles.orbit)
    implementation(libs.orbit.compose)
}