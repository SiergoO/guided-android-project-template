plugins {
    alias(libs.plugins.cleanlibrary.android.feature)
    alias(libs.plugins.cleanlibrary.android.library.compose)
}

android {
    namespace = AndroidConfig.Project.NAMESPACE + ".feature.bookdetails"
}

dependencies {
    implementation(projects.core.common)
    implementation(projects.core.domain)

    implementation(libs.bundles.di)
    implementation(libs.koin.compose)

    implementation(libs.compose.system.ui)

    implementation(libs.bundles.orbit)
    implementation(libs.orbit.compose)

    implementation(libs.bundles.logging)

    implementation(libs.bundles.test)
    androidTestImplementation(libs.bundles.test.android)
}