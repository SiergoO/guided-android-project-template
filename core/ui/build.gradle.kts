plugins {
    alias(libs.plugins.cleanlibrary.android.library)
}

android {
    namespace = AndroidConfig.Project.NAMESPACE + ".core.ui"

    buildFeatures {
        compose = true
    }

    composeOptions {
        kotlinCompilerExtensionVersion = AndroidConfig.Compose.COMPILER_VERSION
    }
}

dependencies {
    implementation(libs.bundles.di)
    implementation(libs.bundles.ui)
    implementation(libs.compose.system.ui)
    implementation(libs.compose.preview)
    implementation(libs.compose.tooling)
    implementation(libs.orbit.core)
}