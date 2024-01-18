package com.template.cleanlibrary.navigation

import androidx.compose.ui.graphics.vector.ImageVector
import com.template.cleanlibrary.feature.library.R as libraryR
import com.template.cleanlibrary.feature.bookshelf.R as bookshelfR

enum class TopLevelDestination(
    val selectedIcon: ImageVector,
    val unselectedIcon: ImageVector,
    val iconTextId: Int,
    val titleTextId: Int,
) {
    LIBRARY(
        selectedIcon = com.template.cleanlibrary.core.designsystem.icon.CleanLibraryIcons.Library,
        unselectedIcon = com.template.cleanlibrary.core.designsystem.icon.CleanLibraryIcons.LibraryOutlined,
        iconTextId = libraryR.string.feature_library_title,
        titleTextId = libraryR.string.feature_library_title,
    ),
    BOOKSHELF(
        selectedIcon = com.template.cleanlibrary.core.designsystem.icon.CleanLibraryIcons.Bookshelf,
        unselectedIcon = com.template.cleanlibrary.core.designsystem.icon.CleanLibraryIcons.BookshelfOutlined,
        iconTextId = bookshelfR.string.feature_bookshelf_title,
        titleTextId = bookshelfR.string.feature_bookshelf_title,
    ),
}
