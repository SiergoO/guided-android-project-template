plugins {
    alias(libs.plugins.cleanlibrary.android.library)
}

android {
    namespace = "com.template.cleanlibrary.core.domain"
}

dependencies {
    api(projects.core.data)

    implementation(libs.koin.core)
    implementation(libs.coroutines.core)
}