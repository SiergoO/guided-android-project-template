import dependencies.Dependency

plugins {
    id(Plugin.ANDROID_LIBRARY)
    id(Plugin.KOTLIN_ANDROID)
}

android {
    namespace = AndroidConfig.Project.NAMESPACE + ".domain"
    compileSdk = AndroidConfig.SDK.COMPILE_VERSION

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }

    kotlinOptions {
        jvmTarget = JavaVersion.VERSION_11.toString()
    }
}

dependencies {
    implementation(Dependency.Coroutines.CORE)

    implementation(Dependency.KoIn.CORE)
}