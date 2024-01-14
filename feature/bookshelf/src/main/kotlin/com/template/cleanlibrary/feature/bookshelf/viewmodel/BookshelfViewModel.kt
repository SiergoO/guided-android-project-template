package com.template.cleanlibrary.feature.bookshelf.viewmodel

import androidx.lifecycle.viewModelScope
import com.template.cleanlibrary.core.ui.base.BaseViewModel
import com.template.cleanlibrary.feature.bookshelf.domain.GetBookshelfUseCase
import kotlinx.coroutines.launch
import org.orbitmvi.orbit.syntax.simple.intent
import org.orbitmvi.orbit.syntax.simple.postSideEffect
import org.orbitmvi.orbit.syntax.simple.reduce

class BookshelfViewModel(
    private val getBookshelfUseCase: GetBookshelfUseCase,
) : BaseViewModel<BookshelfViewModel.State, BookshelfViewModel.SideEffect>(State()) {

    init {
        viewModelScope.launch {
            intent {
                getBookshelfUseCase.invoke()
                    .onSuccess { bookshelf -> reduce { state.copy(bookshelf = bookshelf) } }
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
        val bookshelf: List<String> = emptyList(),
    )
}