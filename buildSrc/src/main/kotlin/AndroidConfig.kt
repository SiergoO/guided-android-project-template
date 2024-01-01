object AndroidConfig {

    object Project {
        // TODO("Change namespace")
        const val NAMESPACE = "com.template"
    }

    // TODO("Change application object name")
    object App {
        private const val VERSION_MAJOR = 0
        private const val VERSION_MINOR = 0
        private const val VERSION_PATCH = 1

        // TODO("Change application id")
        const val APPLICATION_ID = "com.template.cleanlibrary"
        const val VERSION_CODE = (VERSION_MAJOR * 1_000_000) + (VERSION_MINOR * 1_000) + VERSION_PATCH
        const val VERSION_NAME = "${VERSION_MAJOR}.${VERSION_MINOR}.${VERSION_PATCH}"
    }

    object SDK {
        const val COMPILE_VERSION = 33
        const val MIN_VERSION = 24
        const val TARGET_VERSION = 33
    }

    object ApplicationOutput {
        // TODO("Change output application name")
        const val APPLICATION_NAME = "Clean-library"
        const val VERSION_CODE = App.VERSION_CODE
        const val VERSION_NAME = App.VERSION_NAME
    }

    object Kotlin {
        // TODO("Change Kotlin version to latest")
        const val VERSION = "1.8.21"
    }

    object Compose {
        // TODO("Change Compose compiler version to latest")
        const val COMPILER_VERSION = "1.4.7"
    }
}