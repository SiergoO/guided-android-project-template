import dependencies.Dependencies

plugins {
    id(Plugins.ANDROID_APPLICATION)
    id(Plugins.KOTLIN_ANDROID)
}

android {
    namespace = AndroidConfig.Project.NAMESPACE
    compileSdk = AndroidConfig.SDK.COMPILE_VERSION

    defaultConfig {
        applicationId = AndroidConfig.App.APPLICATION_ID
        minSdk = AndroidConfig.SDK.MIN_VERSION
        targetSdk = AndroidConfig.SDK.TARGET_VERSION

        versionCode = AndroidConfig.App.VERSION_CODE
        versionName = AndroidConfig.App.VERSION_NAME

        testInstrumentationRunner = AndroidConfig.Test.TEST_INSTRUMENTATION_RUNNER
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

    kotlinOptions {
        jvmTarget = JavaVersion.VERSION_1_8.toString()
    }

    buildFeatures {
        compose = true
    }

    composeOptions {
        kotlinCompilerExtensionVersion = AndroidConfig.Kotlin.VERSION
    }

    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
}

dependencies {
    implementation(Dependencies.Compose.UI)
    implementation(Dependencies.Compose.FOUNDATION)
    implementation(Dependencies.Compose.MATERIAL)
    implementation(Dependencies.Compose.ACTIVITY)
    implementation(Dependencies.Compose.NAVIGATION)
    implementation(Dependencies.Compose.PERMISSION)
    implementation(Dependencies.Compose.MATERIAL_ICONS)

    implementation(Dependencies.KoIn.CORE)
    implementation(Dependencies.KoIn.ANDROID)

    implementation(Dependencies.Test.JUNIT_KTX)
    androidTestImplementation(Dependencies.Test.JUNIT)
    androidTestImplementation(Dependencies.Test.ESPRESSO_CORE)
}