import dependencies.Dependency

plugins {
    id(Plugin.ANDROID_LIBRARY)
    id(Plugin.KOTLIN_ANDROID)
}

android {
    namespace = AndroidConfig.Project.NAMESPACE + ".domain"
    compileSdk = AndroidConfig.SDK.COMPILE_VERSION
}

dependencies {
    implementation(Dependency.Coroutines.CORE)
}