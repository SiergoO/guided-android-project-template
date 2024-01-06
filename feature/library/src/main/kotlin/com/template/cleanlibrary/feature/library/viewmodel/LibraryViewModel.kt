package com.template.cleanlibrary.feature.library.viewmodel

import androidx.lifecycle.viewModelScope
import com.template.cleanlibrary.core.common.base.BaseViewModel
import com.template.cleanlibrary.core.domain.usecase.GetFirstTitleUseCase
import kotlinx.coroutines.launch
import org.orbitmvi.orbit.syntax.simple.intent
import org.orbitmvi.orbit.syntax.simple.postSideEffect
import org.orbitmvi.orbit.syntax.simple.reduce

class LibraryViewModel(
    getFirstTitleUse: GetFirstTitleUseCase // TODO("Exchange with initial books loading usecase")
) : BaseViewModel<LibraryViewModel.State, LibraryViewModel.SideEffect>(State()) {

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
        val title: String = "",
    )
}