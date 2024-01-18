plugins {
    alias(libs.plugins.cleanlibrary.android.library)
}

android {
    namespace = "com.template.cleanlibrary.core.network"
}

dependencies {
    api(projects.core.common)
}