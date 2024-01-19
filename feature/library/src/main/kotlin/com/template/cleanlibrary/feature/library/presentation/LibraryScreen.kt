package com.template.cleanlibrary.feature.library.presentation

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
import com.template.cleanlibrary.feature.library.presentation.LibraryViewModel.SideEffect.ShowError
import com.template.cleanlibrary.feature.library.presentation.LibraryViewModel.SideEffect.NavigateToBookDetailsScreen
import com.template.cleanlibrary.feature.library.presentation.LibraryViewModel.Action.BookClicked
import org.koin.androidx.compose.getViewModel
import org.orbitmvi.orbit.compose.collectAsState
import org.orbitmvi.orbit.compose.collectSideEffect

@Composable
internal fun LibraryRoute(
    onNavigateToBookDetailsScreen: (bookId: String) -> Unit,
) {
    val viewModel = getViewModel<LibraryViewModel>()
    val state = viewModel.collectAsState()

    viewModel.collectSideEffect { sideEffect ->
        when (sideEffect) {
            is NavigateToBookDetailsScreen -> onNavigateToBookDetailsScreen(sideEffect.bookId)

            is ShowError -> {}
        }
    }

    LibraryScreen(
        state = state,
        onBookClick = { bookId: String ->
            viewModel.sendAction(BookClicked(bookId))
        }
    )
}

@Composable
private fun LibraryScreen(
    state: State<LibraryViewModel.State>,
    onBookClick: (bookId: String) -> Unit
) {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.SpaceEvenly,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = state.value.books.toString(),
            color = MaterialTheme.colorScheme.onBackground,
            textAlign = TextAlign.Center
        )
        Button(
            modifier = Modifier
                .fillMaxWidth()
                .height(48.dp)
                .padding(horizontal = 16.dp),
            shape = MaterialTheme.shapes.medium,
            onClick = { onBookClick("1234") }
        ) {
            Text(
                text = "Go to book details screen",
                style = MaterialTheme.typography.labelSmall
            )
        }
    }
}