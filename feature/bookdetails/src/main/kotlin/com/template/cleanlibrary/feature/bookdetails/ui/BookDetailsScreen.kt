package com.template.cleanlibrary.feature.bookdetails.ui

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
import androidx.compose.ui.unit.dp
import com.template.cleanlibrary.feature.bookdetails.viewmodel.BookDetailsViewModel
import com.template.cleanlibrary.feature.bookdetails.viewmodel.BookDetailsViewModel.Action.AuthorDetailsClicked
import com.template.cleanlibrary.feature.bookdetails.viewmodel.BookDetailsViewModel.SideEffect.NavigateToAuthorDetailsScreen
import com.template.cleanlibrary.feature.bookdetails.viewmodel.BookDetailsViewModel.SideEffect.ShowError
import org.koin.androidx.compose.getViewModel
import org.orbitmvi.orbit.compose.collectAsState
import org.orbitmvi.orbit.compose.collectSideEffect

@Composable
internal fun BookDetailsRoute(
    onNavigateToAuthorDetailsScreen: (authorId: String) -> Unit
) {
    val viewModel = getViewModel<BookDetailsViewModel>()
    val state = viewModel.collectAsState()

    viewModel.collectSideEffect { sideEffect ->
        when (sideEffect) {
            is NavigateToAuthorDetailsScreen -> onNavigateToAuthorDetailsScreen(sideEffect.authorId)

            is ShowError -> {}
        }
    }

    BookDetailsScreen(
        state = state,
        onAuthorDetailsClick = { authorId: String ->
            viewModel.sendAction(AuthorDetailsClicked(authorId))
        }
    )
}

@Composable
private fun BookDetailsScreen(
    state: State<BookDetailsViewModel.State>,
    onAuthorDetailsClick: (authorId: String) -> Unit,
) {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.SpaceEvenly,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Button(
            modifier = Modifier
                .fillMaxWidth()
                .height(48.dp)
                .padding(horizontal = 16.dp),
            shape = MaterialTheme.shapes.medium,
            onClick = { onAuthorDetailsClick("1234") }
        ) {
            Text(
                text = state.value.bookId,
                style = MaterialTheme.typography.labelSmall
            )
        }
    }
}