package com.template.cleanlibrary.navigation

sealed class NavDestination(open val route: String) {
    object Library : NavDestination("route_library")
    object BookDetails : NavDestination("route_book_details")
    object AuthorDetails : NavDestination("route_author_details")
    object Bookshelf : NavDestination("route_bookshelf")

    companion object {
        // Map of route strings associated with NavDestination objects
        private val destinationMap = mapOf(
            "route_library" to Library,
            "route_book_details" to BookDetails,
            "route_author_details" to AuthorDetails,
            "route_bookshelf" to Bookshelf,
        )

        fun getByRoute(route: String?): NavDestination {
            return destinationMap[route] ?: Library
        }
    }
}
