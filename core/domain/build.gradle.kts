plugins {
    id(libs.plugins.android.library.get().pluginId) apply true
    id(libs.plugins.kotlin.android.get().pluginId) apply true
}

android {
    namespace = AndroidConfig.Project.NAMESPACE + ".core.domain"
    compileSdk = AndroidConfig.SDK.COMPILE_VERSION

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }

    kotlinOptions {
        jvmTarget = JavaVersion.VERSION_11.toString()
    }
}

dependencies {
    implementation(libs.bundles.logging)
    implementation(libs.coroutines.core)
    implementation(libs.koin.core)
}