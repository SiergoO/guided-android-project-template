package com.template.cleanlibrary.feature.bookshelf.viewmodel

import com.template.cleanlibrary.core.common.base.BaseViewModel
import org.orbitmvi.orbit.syntax.simple.intent
import org.orbitmvi.orbit.syntax.simple.postSideEffect

class BookshelfViewModel(
    // TODO("Add bookshelf load usecase")
) : BaseViewModel<BookshelfViewModel.State, BookshelfViewModel.SideEffect>(State()) {

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
        val title: String = "Bookshelf",
    )
}