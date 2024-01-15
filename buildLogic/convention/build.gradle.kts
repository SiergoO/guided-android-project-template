import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    `kotlin-dsl`
}

group = "com.template.cleanlibrary.buildlogic"

// Configure the build-logic plugins to target JDK 17
// This matches the JDK used to build the project, and is not related to what is running on device.
java {
    sourceCompatibility = JavaVersion.VERSION_17
    targetCompatibility = JavaVersion.VERSION_17
}

tasks.withType<KotlinCompile>().configureEach {
    kotlinOptions {
        jvmTarget = JavaVersion.VERSION_17.toString()
    }
}

dependencies {
    compileOnly(libs.build.gradle)
    compileOnly(libs.kotlin.gradle)
}

gradlePlugin {
    plugins {
        register("androidApplication") {
            id = "cleanlibrary.android.application"
            implementationClass = "AndroidApplicationConventionPlugin"
        }
    }
    plugins {
        register("androidApplicationCompose") {
            id = "cleanlibrary.android.application.compose"
            implementationClass = "AndroidApplicationComposeConventionPlugin"
        }
    }
    plugins {
        register("androidFeature") {
            id = "cleanlibrary.android.feature"
            implementationClass = "AndroidFeatureConventionPlugin"
        }
    }
    plugins {
        register("androidKoin") {
            id = "cleanlibrary.android.koin"
            implementationClass = "AndroidKoinConventionPlugin"
        }
    }
    plugins {
        register("androidLibrary") {
            id = "cleanlibrary.android.library"
            implementationClass = "AndroidLibraryConventionPlugin"
        }
    }
    plugins {
        register("androidLibraryCompose") {
            id = "cleanlibrary.android.library.compose"
            implementationClass = "AndroidLibraryComposeConventionPlugin"
        }
    }
    plugins {
        register("androidOrbit") {
            id = "cleanlibrary.android.orbit"
            implementationClass = "AndroidOrbitConventionPlugin"
        }
    }
}