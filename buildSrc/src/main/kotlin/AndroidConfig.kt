object AndroidConfig {

    // TODO("Change application object name")
    object App {
        private const val VERSION_MAJOR = 0
        private const val VERSION_MINOR = 0
        private const val VERSION_PATCH = 1

        // TODO("Change application id")
        const val APPLICATION_ID = "com.template.perfectprojecttemplate"
        const val VERSION_CODE = (VERSION_MAJOR * 1_000_000) + (VERSION_MINOR * 1_000) + VERSION_PATCH
        const val VERSION_NAME = "${VERSION_MAJOR}.${VERSION_MINOR}.${VERSION_PATCH}"
    }

    object Project {
        // TODO("Change namespace")
        const val NAMESPACE = "com.template"
    }

    object Kotlin {
        // TODO("Change Kotlin version to latest")
        const val KOTLIN_VERSION = "1.8.21"
    }

    object SDK {
        const val COMPILE_SDK_VERSION = 33
        const val MIN_SDK_VERSION = 24
        const val TARGET_SDK_VERSION = 33
    }
}