pluginManagement {
    includeBuild("buildLogic")
    repositories {
        google()
        mavenCentral()
        gradlePluginPortal()
    }
}

dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
    }
}

rootProject.name = "CleanLibrary"

enableFeaturePreview("TYPESAFE_PROJECT_ACCESSORS")
include(":app")
include(":core:common")
include(":core:data")
include(":core:designsystem")
include(":core:domain")
include(":core:network")
include(":core:ui")
include(":feature:authordetails")
include(":feature:bookdetails")
include(":feature:bookshelf")
include(":feature:library")
