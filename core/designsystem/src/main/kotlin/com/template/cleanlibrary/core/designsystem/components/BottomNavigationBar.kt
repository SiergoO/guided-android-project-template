package com.template.cleanlibrary.core.designsystem.components

import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun BottomNavigationBar(
    modifier: Modifier = Modifier,
    content: @Composable RowScope.() -> Unit,
) {

    NavigationBar(
        modifier = modifier
            .navigationBarsPadding()
            .height(64.dp),
        containerColor = MaterialTheme.colorScheme.primary,
        contentColor = MaterialTheme.colorScheme.tertiary,
        content = content
    )
}