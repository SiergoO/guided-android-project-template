plugins {
    alias(libs.plugins.cleanlibrary.android.feature)
    alias(libs.plugins.cleanlibrary.android.library.compose)
}

android {
    namespace = AndroidConfig.Project.NAMESPACE + ".feature.authordetails"
}

dependencies {

    implementation(projects.core.common)
    implementation(projects.core.domain)

    implementation(libs.bundles.di)
    implementation(libs.koin.compose)

    implementation(libs.bundles.orbit)
    implementation(libs.orbit.compose)

    implementation(libs.bundles.logging)
}