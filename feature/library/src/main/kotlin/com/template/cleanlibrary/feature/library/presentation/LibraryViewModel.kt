package com.template.cleanlibrary.feature.library.presentation

import androidx.lifecycle.viewModelScope
import com.template.cleanlibrary.core.ui.base.BaseViewModel
import com.template.cleanlibrary.feature.library.domain.usecase.LoadBooksBySearchQueryUseCase
import kotlinx.coroutines.launch
import org.orbitmvi.orbit.syntax.simple.intent
import org.orbitmvi.orbit.syntax.simple.postSideEffect
import org.orbitmvi.orbit.syntax.simple.reduce

class LibraryViewModel(
    private val loadBooksBySearchQueryUseCase: LoadBooksBySearchQueryUseCase,
) : BaseViewModel<LibraryViewModel.State, LibraryViewModel.SideEffect>(State()) {

    init {
        viewModelScope.launch {
            intent {
                loadBooksBySearchQueryUseCase.invoke("")
                    .onSuccess { books -> reduce { state.copy(books = books) } }
                    .onFailure { postSideEffect(SideEffect.ShowError(it.message)) }
            }
        }
    }

    fun sendAction(action: Action) {
        when (action) {
            is Action.BookClicked -> {
                intent {
                    postSideEffect(SideEffect.NavigateToBookDetailsScreen(action.bookId))
                }
            }
        }
    }

    sealed class SideEffect {
        data class NavigateToBookDetailsScreen(val bookId: String) : SideEffect()
        data class ShowError(val message: String?) : SideEffect()
    }

    sealed class Action {
        data class BookClicked(val bookId: String) : Action()
    }

    data class State(
        val books: List<String> = emptyList(),
    )
}