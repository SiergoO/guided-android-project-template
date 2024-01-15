plugins {
    alias(libs.plugins.cleanlibrary.android.library)
    alias(libs.plugins.cleanlibrary.android.library.compose)
}

android {
    namespace = "com.template.cleanlibrary.core.designsystem"
}

dependencies {
    api(libs.compose.foundation)
    api(libs.compose.foundation.layout)
    api(libs.compose.material.iconsExtended)
    api(libs.compose.material3)
    api(libs.compose.ui.tooling.preview)
    api(libs.compose.ui.util)
}