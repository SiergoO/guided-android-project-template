plugins {
    alias(libs.plugins.cleanlibrary.android.library)
}

android {
    namespace = AndroidConfig.Project.NAMESPACE + ".core.domain"
}

dependencies {
    api(projects.core.data)

    implementation(libs.bundles.logging)
    implementation(libs.koin.core)
    implementation(libs.coroutines.core)
}