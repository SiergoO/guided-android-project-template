plugins {
    alias(libs.plugins.cleanlibrary.android.feature)
    alias(libs.plugins.cleanlibrary.android.library.compose)
    alias(libs.plugins.cleanlibrary.android.koin)
}

android {
    namespace = "com.template.cleanlibrary.feature.bookdetails"
}

dependencies {
    implementation(projects.core.data)

    implementation(libs.koin.compose)
    implementation(libs.orbit.compose)
}