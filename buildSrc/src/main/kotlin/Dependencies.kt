package dependencies

object Dependencies {

    object Compose {
        private const val VERSION_COMPOSE = "1.3.1"
        private const val VERSION_ACCOMPANIST = "0.30.0"
        const val UI = "androidx.compose.ui:ui:$VERSION_COMPOSE"
        const val TOOLING = "androidx.compose.ui:ui-tooling:$VERSION_COMPOSE"
        const val PREVIEW = "androidx.compose.ui:ui-tooling-preview:$VERSION_COMPOSE"
        const val FOUNDATION = "androidx.compose.foundation:foundation:$VERSION_COMPOSE"
        const val MATERIAL = "androidx.compose.material:material:$VERSION_COMPOSE"
        const val MATERIAL3 = "androidx.compose.material3:material3:1.0.1"
        const val MATERIAL_ICONS = "androidx.compose.material:material-icons-extended:$VERSION_COMPOSE"
        const val ACTIVITY = "androidx.activity:activity-compose:1.6.1"
        const val NAVIGATION = "androidx.navigation:navigation-compose:2.5.3"
        const val SUSTEM_UI = "com.google.accompanist:accompanist-systemuicontroller:$VERSION_ACCOMPANIST"
        const val PERMISSION = "com.google.accompanist:accompanist-permissions:$VERSION_ACCOMPANIST"
    }

    object OrbitMVI {
        private const val VERSION = "6.0.0"
        const val CORE = "org.orbit-mvi:orbit-core:${VERSION}"
        const val VIEWMODEL = "org.orbit-mvi:orbit-viewmodel:${VERSION}"
        const val COMPOSE = "org.orbit-mvi:orbit-compose:${VERSION}"
        const val TEST = "org.orbit-mvi:orbit-test:${VERSION}"
    }

    object ViewModel {
        private const val VERSION = "2.6.1"
        const val KTX = "androidx.lifecycle:lifecycle-viewmodel-ktx:${VERSION}"
        const val COMPOSE = "androidx.lifecycle:lifecycle-viewmodel-compose:${VERSION}"
    }

    object Coroutines {
        private const val VERSION = "1.7.1"
        const val CORE = "org.jetbrains.kotlinx:kotlinx-coroutines-core:${VERSION}"
        const val ANDROID = "org.jetbrains.kotlinx:kotlinx-coroutines-android:${VERSION}"
    }

    object KoIn {
        private const val VERSION = "3.4.0"
        const val ANDROID = "io.insert-koin:koin-android:$VERSION"
        const val CORE = "io.insert-koin:koin-core:$VERSION"
    }

    object Room {
        private const val VERSION = "2.5.1"
        const val KTX = "androidx.room:room-ktx:$VERSION"
        const val RUNTIME = "androidx.room:room-runtime:$VERSION"
        const val COMPILER = "androidx.room:room-compiler:$VERSION"
    }

    object Ktor {
        private const val VERSION = "2.2.1"
        const val CORE = "io.ktor:ktor-client-core:${VERSION}"
        const val CIO = "io.ktor:ktor-client-cio:${VERSION}"
        const val OKHTTP = "io.ktor:ktor-client-okhttp:${VERSION}"
        const val NEGOTIATION = "io.ktor:ktor-client-content-negotiation:${VERSION}"
        const val SERIALIZATION = "io.ktor:ktor-serialization-kotlinx-json:${VERSION}"
        const val DARWIN = "io.ktor:ktor-client-darwin:${VERSION}"
        const val LOGGING = "io.ktor:ktor-client-logging:${VERSION}"
        const val AUTH = "io.ktor:ktor-client-auth:${VERSION}"
    }

    object Test {
        const val JUNIT = "junit:junit:4.13.2"
        const val JUNIT_KTX = "androidx.test.ext:junit-ktx:1.1.5"
        const val ESPRESSO_CORE = "androidx.test.espresso:espresso-core:3.5.1"
    }

    const val SERIALIZATION = "org.jetbrains.kotlinyx:kotlinx-serialization-json:1.5.1"
    const val DATASTORE = "androidx.datastore:datastore-preferences:1.0.0"
}