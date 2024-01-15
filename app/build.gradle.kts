plugins {
    alias(libs.plugins.cleanlibrary.android.application)
    alias(libs.plugins.cleanlibrary.android.application.compose)
    alias(libs.plugins.cleanlibrary.android.koin)
}

android {
    namespace = "com.template.cleanlibrary.app"

    defaultConfig {
        applicationId = "com.template.cleanlibrary"

        versionCode = 1
        versionName = "0.0.1"
    }

    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro"
            )
        }
    }

    applicationVariants.all {
        outputs.all {
            val editableOutput = this as com.android.build.gradle.internal.api.BaseVariantOutputImpl
            editableOutput.outputFileName =
                "Clean-library-${defaultConfig.versionName}(${defaultConfig.versionCode})-${buildType.name}.apk"
        }
    }

    buildFeatures {
        buildConfig = true
    }

    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
}

dependencies {
    implementation(projects.core.common)
    implementation(projects.core.data)
    implementation(projects.core.designsystem)
    implementation(projects.core.domain)
    implementation(projects.core.ui)
    implementation(projects.feature.authordetails)
    implementation(projects.feature.bookdetails)
    implementation(projects.feature.bookshelf)
    implementation(projects.feature.library)

    implementation(libs.compose.navigation)
    implementation(libs.compose.permission)
    implementation(libs.core.splash.screen)
    implementation(libs.timber)
}