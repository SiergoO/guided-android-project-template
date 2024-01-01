plugins {
    id(libs.plugins.android.library.get().pluginId) apply true
    id(libs.plugins.kotlin.android.get().pluginId) apply true
}

android {
    namespace = AndroidConfig.Project.NAMESPACE + ".second"
    compileSdk = AndroidConfig.SDK.COMPILE_VERSION

    defaultConfig {
        minSdk = AndroidConfig.SDK.MIN_VERSION
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }

    kotlinOptions {
        jvmTarget = JavaVersion.VERSION_11.toString()
    }

    buildFeatures {
        compose = true
    }

    composeOptions {
        kotlinCompilerExtensionVersion = AndroidConfig.Compose.COMPILER_VERSION
    }
}

dependencies {

    implementation(projects.core.common)
    implementation(projects.core.domain)

    implementation(libs.bundles.di)
    implementation(libs.koin.compose)

    implementation(libs.bundles.ui)
    implementation(libs.compose.system.ui)
    implementation(libs.compose.preview)
    implementation(libs.compose.tooling)

    implementation(libs.bundles.orbit)
    implementation(libs.orbit.compose)

    implementation(libs.bundles.logging)

    implementation(libs.bundles.test)
    androidTestImplementation(libs.bundles.test.android)
}