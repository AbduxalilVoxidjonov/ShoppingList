pluginManagement {
    repositories {
        google()
        mavenCentral()
        gradlePluginPortal()

        maven(" https://dl.bintray.com/kodein-framework/Kodein-DI")
    }
    plugins {
        id("org.gradle.toolchains.foojay-resolver-convention") version ("0.5.0")
    }

}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
        maven(" https://jitpack.io")
    }

}

rootProject.name = "ShoppingList"
include(":app")
