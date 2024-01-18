plugins {
    alias(libs.plugins.cleanlibrary.android.library)
    alias(libs.plugins.cleanlibrary.android.koin)
    id(libs.plugins.serialization.get().pluginId) apply true
}

android {
    namespace = "com.template.cleanlibrary.core.data"

    packaging {
        resources.excludes += "META-INF/*"
    }
}

dependencies {
    api(projects.core.common)

    implementation(libs.coroutines.core)
    implementation(libs.datastore)
    implementation(libs.serialization.json)
}