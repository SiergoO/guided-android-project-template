plugins {
    alias(libs.plugins.cleanlibrary.android.application)
    alias(libs.plugins.cleanlibrary.android.application.compose)
    alias(libs.plugins.cleanlibrary.android.koin)
}

android {
    namespace = AndroidConfig.Project.NAMESPACE + ".app"

    defaultConfig {
        applicationId = AndroidConfig.App.APPLICATION_ID

        versionCode = AndroidConfig.App.VERSION_CODE
        versionName = AndroidConfig.App.VERSION_NAME
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
            val apkName = with(AndroidConfig.ApplicationOutput) {
                "$APPLICATION_NAME-${VERSION_NAME}($VERSION_CODE)-${buildType.name}.apk"
            }
            editableOutput.outputFileName = apkName
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
    implementation(projects.core.domain)
    implementation(projects.core.ui)
    implementation(projects.core.designsystem)
    implementation(projects.feature.library)
    implementation(projects.feature.bookdetails)
    implementation(projects.feature.authordetails)
    implementation(projects.feature.bookshelf)

    api(libs.timber)
    implementation(libs.compose.navigation)
    implementation(libs.compose.permission)
    implementation(libs.orbit.core)
    implementation(libs.core.splash.screen)
}