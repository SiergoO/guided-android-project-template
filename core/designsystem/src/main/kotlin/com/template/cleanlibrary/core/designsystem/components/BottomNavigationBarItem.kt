package com.template.cleanlibrary.core.designsystem.components

import androidx.compose.foundation.layout.RowScope
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun RowScope.BottomNavigationBarItem(
    modifier: Modifier = Modifier,
    selected: Boolean,
    onClick: () -> Unit,
    icon: @Composable () -> Unit,
    selectedIcon: @Composable () -> Unit = icon,
    enabled: Boolean = true,
    label: @Composable (() -> Unit)? = null,
    alwaysShowLabel: Boolean = true,
) {
    NavigationBarItem(
        modifier = modifier,
        selected = selected,
        onClick = onClick,
        icon = if (selected) selectedIcon else icon,
        enabled = enabled,
        label = label,
        alwaysShowLabel = true,
        colors = NavigationBarItemDefaults.colors(
            selectedIconColor = MaterialTheme.colorScheme.background,
            selectedTextColor = MaterialTheme.colorScheme.background,
            indicatorColor = MaterialTheme.colorScheme.tertiary,
            unselectedIconColor = MaterialTheme.colorScheme.background.copy(alpha = 0.6f),
            unselectedTextColor = MaterialTheme.colorScheme.background.copy(alpha = 0.6f),
        ),
    )
}