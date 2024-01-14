plugins {
    alias(libs.plugins.cleanlibrary.android.library)
    id(libs.plugins.serialization.get().pluginId) apply true
}

android {
    namespace = AndroidConfig.Project.NAMESPACE + ".core.data"

    packaging {
        resources.excludes += "META-INF/*"
    }
}

dependencies {
    api(projects.core.common)

    implementation(libs.bundles.di)
    implementation(libs.bundles.logging)
    implementation(libs.bundles.network)
    implementation(libs.coroutines.core)
    implementation(libs.datastore)
    implementation(libs.serialization.json)
}