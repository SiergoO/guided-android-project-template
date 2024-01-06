package com.template.cleanlibrary.feature.bookdetails.viewmodel

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.viewModelScope
import com.template.cleanlibrary.core.common.base.BaseViewModel
import com.template.cleanlibrary.feature.bookdetails.navigation.BookArgs
import kotlinx.coroutines.launch
import org.orbitmvi.orbit.syntax.simple.intent
import org.orbitmvi.orbit.syntax.simple.postSideEffect
import org.orbitmvi.orbit.syntax.simple.reduce

class BookDetailsViewModel(
    savedStateHandle: SavedStateHandle
) : BaseViewModel<BookDetailsViewModel.State, BookDetailsViewModel.SideEffect>(State()) {

    private val bookArgs: BookArgs = BookArgs(savedStateHandle)
    private val bookId: String = bookArgs.bookId

    init {
        viewModelScope.launch {
            intent {
                reduce { state.copy(bookId = bookId) }
            }
        }
    }

    fun sendAction(action: Action) {
        when (action) {
            is Action.AuthorDetailsClicked -> {
                intent {
                    postSideEffect(SideEffect.NavigateToAuthorDetailsScreen(action.authorId))
                }
            }
        }
    }

    sealed class SideEffect {
        data class NavigateToAuthorDetailsScreen(val authorId: String) : SideEffect()
        data class ShowError(val message: String?) : SideEffect()
    }

    sealed interface Action {
        data class AuthorDetailsClicked(val authorId: String) : Action
    }

    data class State(
        val bookId: String = "",
    )
}