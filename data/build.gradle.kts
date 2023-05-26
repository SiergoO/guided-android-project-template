import dependencies.Dependency

plugins {
    id(Plugin.ANDROID_LIBRARY)
    id(Plugin.KOTLIN_ANDROID)
    id(Plugin.SERIALIZATION)
}

android {
    namespace = AndroidConfig.Project.NAMESPACE + ".data"
    compileSdk = AndroidConfig.SDK.COMPILE_VERSION

    defaultConfig {
        minSdk = AndroidConfig.SDK.MIN_VERSION
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }

    kotlinOptions {
        jvmTarget = JavaVersion.VERSION_11.toString()
    }

    packaging {
        resources.excludes += "META-INF/*"
    }
}

dependencies {
//    implementation(project(Module.Core.DOMAIN))

    implementation(Dependency.Coroutines.CORE)

    implementation(Dependency.KoIn.ANDROID)
    implementation(Dependency.KoIn.CORE)

    implementation(Dependency.Ktor.CORE)
    implementation(Dependency.Ktor.CIO)
    implementation(Dependency.Ktor.OKHTTP)
    implementation(Dependency.Ktor.NEGOTIATION)
    implementation(Dependency.Ktor.SERIALIZATION)
    implementation(Dependency.Ktor.LOGGING)
    implementation(Dependency.Ktor.AUTH)

    implementation(Dependency.DATASTORE)
    implementation(Dependency.SERIALIZATION)

    implementation(Dependency.TIMBER)
}