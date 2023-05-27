package com.template.perfectprojecttemplate.navigation

sealed class NavDestination(open val destination: String) {
    object First : NavDestination("destination_first_screen")
    object Second : NavDestination("destination_second_screen")
}
