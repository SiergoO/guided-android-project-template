plugins {
    id(libs.plugins.android.library.get().pluginId) apply true
    id(libs.plugins.kotlin.android.get().pluginId) apply true
    id(libs.plugins.serialization.get().pluginId) apply true
}

android {
    namespace = AndroidConfig.Project.NAMESPACE + ".data"
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

    packaging {
        resources.excludes += "META-INF/*"
    }
}

dependencies {
    implementation(projects.core.domain)

    implementation(libs.bundles.di)
    implementation(libs.bundles.logging)
    implementation(libs.bundles.network)
    implementation(libs.coroutines.core)
    implementation(libs.datastore)
    implementation(libs.serialization.json)
}