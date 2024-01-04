package com.template.cleanlibrary.feature.library.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.template.cleanlibrary.feature.library.viewmodel.LibraryViewModel
import org.koin.androidx.compose.getViewModel
import org.orbitmvi.orbit.compose.collectAsState
import org.orbitmvi.orbit.compose.collectSideEffect

@Composable
internal fun LibraryRoute(
    onNavigateToBookDetailsScreen: (bookId: String) -> Unit
) {
    val viewModel = getViewModel<LibraryViewModel>()
    val state = viewModel.collectAsState()

    viewModel.collectSideEffect { sideEffect ->
        when (sideEffect) {
            LibraryViewModel.SideEffect.NavigateToBookDetailsScreen -> onNavigateToBookDetailsScreen.invoke("")
            is LibraryViewModel.SideEffect.ShowError -> {}
        }
    }

    LibraryScreen(
        state = state,
        showBookDetailsScreenAction = onNavigateToBookDetailsScreen
    )
}

@Composable
internal fun LibraryScreen(
    state: State<LibraryViewModel.State>,
    showBookDetailsScreenAction: (bookId: String) -> Unit
) {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.SpaceEvenly,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = state.value.title,
            color = MaterialTheme.colorScheme.onBackground,
            textAlign = TextAlign.Center
        )
        Button(
            modifier = Modifier
                .fillMaxWidth()
                .height(48.dp)
                .padding(horizontal = 16.dp),
            shape = MaterialTheme.shapes.medium,
            onClick = { showBookDetailsScreenAction("") }
        ) {
            Text(
                text = "Go to second screen",
                style = MaterialTheme.typography.labelSmall
            )
        }
    }
}