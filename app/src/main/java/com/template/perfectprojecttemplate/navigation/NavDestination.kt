package com.template.perfectprojecttemplate.navigation

sealed class NavDestination(open val route: String) {
    object Books : NavDestination("route_books_screen")
    object Details : NavDestination("route_details_screen")

    companion object {
        // Map of route strings associated with NavDestination objects
        private val destinationMap = mapOf(
            "route_books_screen" to Books,
            "route_details_screen" to Details,
        )

        fun getByRoute(route: String?): NavDestination {
            return destinationMap[route] ?: Books
        }
    }
}
