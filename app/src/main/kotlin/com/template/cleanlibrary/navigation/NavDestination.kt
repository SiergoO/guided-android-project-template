package com.template.cleanlibrary.navigation

sealed class NavDestination(open val route: String) {
    object Library : NavDestination("route_library_screen")
    object BookDetails : NavDestination("route_book_details_screen")
    object AuthorDetails : NavDestination("route_author_details_screen")
    object Bookshelf : NavDestination("route_bookshelf_screen")

    companion object {
        // Map of route strings associated with NavDestination objects
        private val destinationMap = mapOf(
            "route_library_screen" to Library,
            "route_book_details_screen" to BookDetails,
            "route_author_details_screen" to AuthorDetails,
            "route_bookshelf_screen" to Bookshelf,
        )

        fun getByRoute(route: String?): NavDestination {
            return destinationMap[route] ?: Library
        }
    }
}
