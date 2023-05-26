package com.template.perfectprojecttemplate.navigation

sealed class NavDestination(open val destination: String) {
    object Main : NavDestination("destination_main_screen")
    object First : NavDestination("destination_first_screen")
}
