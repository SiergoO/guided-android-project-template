buildscript {
    repositories {
        google()
        mavenCentral()
    }

    dependencies {
        classpath("com.android.tools.build:gradle:8.0.1")
        classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:${AndroidConfig.Kotlin.VERSION}")
        classpath("org.jetbrains.kotlin:kotlin-serialization:${AndroidConfig.Kotlin.VERSION}")
    }
}