plugins {
    alias(libs.plugins.cleanlibrary.android.application)
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
        compose = true
        buildConfig = true
    }

    composeOptions {
        kotlinCompilerExtensionVersion = AndroidConfig.Compose.COMPILER_VERSION
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

    implementation(libs.bundles.di)
    implementation(libs.bundles.logging)
//    implementation(libs.bundles.ui)
    implementation(libs.compose.navigation)
    implementation(libs.compose.permission)
    implementation(libs.orbit.core)
    implementation(libs.splash)

    implementation(libs.bundles.test)
    androidTestImplementation(libs.bundles.test.android)
}