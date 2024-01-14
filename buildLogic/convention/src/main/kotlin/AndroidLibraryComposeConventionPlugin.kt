import com.android.build.gradle.LibraryExtension
import com.template.cleanlibrary.configureAndroidCompose
import com.template.cleanlibrary.libs
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.configure
import org.gradle.kotlin.dsl.dependencies

class AndroidLibraryComposeConventionPlugin : Plugin<Project> {
    override fun apply(target: Project) {
        with(target) {
            pluginManager.apply("com.android.library")

            extensions.configure<LibraryExtension> {
                configureAndroidCompose(this)
            }

            dependencies {
                add("implementation", libs.findLibrary("compose.runtime").get())
            }
        }
    }
}