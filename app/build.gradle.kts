plugins {
    id(libs.plugins.android.application.get().pluginId) apply true
    id(libs.plugins.kotlin.android.get().pluginId) apply true
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

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }

    kotlinOptions {
        jvmTarget = JavaVersion.VERSION_11.toString()

        freeCompilerArgs = freeCompilerArgs + listOf(
            "-opt-in=androidx.compose.animation.ExperimentalAnimationApi"
        )
    }

    buildFeatures {
        compose = true
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
    implementation(projects.feature.first)
    implementation(projects.feature.second)

    implementation(libs.bundles.di)
    implementation(libs.bundles.logging)
    implementation(libs.bundles.ui)
    implementation(libs.compose.navigation)
    implementation(libs.compose.permission)
    implementation(libs.orbit.core)
    implementation(libs.splash)

    implementation(libs.bundles.test)
    androidTestImplementation(libs.bundles.test.android)
}