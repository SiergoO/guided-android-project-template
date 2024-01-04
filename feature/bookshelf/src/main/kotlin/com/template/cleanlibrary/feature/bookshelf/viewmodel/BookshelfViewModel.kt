package com.template.cleanlibrary.feature.bookshelf.viewmodel

import androidx.lifecycle.viewModelScope
import com.template.cleanlibrary.core.common.base.BaseViewModel
import com.template.cleanlibrary.core.domain.usecase.GetFirstTitleUseCase
import kotlinx.coroutines.launch
import org.orbitmvi.orbit.syntax.simple.intent
import org.orbitmvi.orbit.syntax.simple.postSideEffect
import org.orbitmvi.orbit.syntax.simple.reduce

class BookshelfViewModel(
    getFirstTitleUse: GetFirstTitleUseCase // TODO("Exchange with bookshelf load usecase")
) : BaseViewModel<BookshelfViewModel.State, BookshelfViewModel.SideEffect>(State()) {

    init {
        viewModelScope.launch {
            getFirstTitleUse(Unit).onSuccess {
                intent {
                    reduce { state.copy(title = it) }
                }
            }
        }
    }

    fun sendAction(action: Action) {
        when (action) {
            is Action.BookClicked -> {
                intent {
                    postSideEffect(SideEffect.NavigateToBookDetailsScreen)
                }
            }
        }
    }

    sealed class SideEffect {
        object NavigateToBookDetailsScreen : SideEffect()
        data class ShowError(val message: String?) : SideEffect()
    }

    sealed class Action {
        object BookClicked : Action()
    }

    data class State(
        val title: String = "",
    )
}