import dependencies.Dependency

plugins {
    id(Plugin.ANDROID_APPLICATION)
    id(Plugin.KOTLIN_ANDROID)
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

    implementation(project(Module.COMMON))
    implementation(project(Module.DATA))
    implementation(project(Module.DOMAIN))
    implementation(project(Module.Presentation.FIRST))
    implementation(project(Module.Presentation.SECOND))

    implementation(Dependency.Compose.UI)
    implementation(Dependency.Compose.FOUNDATION)
    implementation(Dependency.Compose.MATERIAL)
    implementation(Dependency.Compose.MATERIAL3)
    implementation(Dependency.Compose.ACTIVITY)
    implementation(Dependency.Compose.ANIMATED_NAVIGATION)
    implementation(Dependency.Compose.PERMISSION)
    implementation(Dependency.Compose.MATERIAL_ICONS)

    implementation(Dependency.OrbitMVI.CORE)

    implementation(Dependency.SPLASH)

    implementation(Dependency.KoIn.CORE)
    implementation(Dependency.KoIn.ANDROID)

    implementation(Dependency.Test.JUNIT_KTX)
    androidTestImplementation(Dependency.Test.JUNIT)
    androidTestImplementation(Dependency.Test.ESPRESSO_CORE)
}