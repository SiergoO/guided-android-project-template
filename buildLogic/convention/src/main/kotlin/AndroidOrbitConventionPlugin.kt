import com.template.cleanlibrary.libs
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.dependencies

class AndroidOrbitConventionPlugin: Plugin<Project> {
    override fun apply(target: Project) {
        with(target) {
            dependencies {
                add("implementation", libs.findLibrary("orbit.compose").get())
                add("implementation", libs.findLibrary("orbit.core").get())
                add("implementation", libs.findLibrary("orbit.viewmodel").get())
            }
        }
    }
}