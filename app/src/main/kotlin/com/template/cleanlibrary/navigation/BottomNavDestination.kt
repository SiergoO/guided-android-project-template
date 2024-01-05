package com.template.cleanlibrary.navigation

import androidx.compose.ui.graphics.vector.ImageVector
import com.template.cleanlibrary.core.ui.icon.CleanLibraryIcons
import com.template.cleanlibrary.feature.library.R as libraryR
import com.template.cleanlibrary.feature.bookshelf.R as bookshelfR

enum class BottomNavDestination(
    val selectedIcon: ImageVector,
    val unselectedIcon: ImageVector,
    val iconTextId: Int,
    val titleTextId: Int,
) {
    LIBRARY(
        selectedIcon = CleanLibraryIcons.Library,
        unselectedIcon = CleanLibraryIcons.LibraryOutlined,
        iconTextId = libraryR.string.feature_library_title,
        titleTextId = libraryR.string.feature_library_title,
    ),
    BOOKSHELF(
        selectedIcon = CleanLibraryIcons.Bookshelf,
        unselectedIcon = CleanLibraryIcons.BookshelfOutlined,
        iconTextId = bookshelfR.string.feature_bookshelf_title,
        titleTextId = bookshelfR.string.feature_bookshelf_title,
    ),
}
