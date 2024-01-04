package com.template.cleanlibrary.feature.bookdetails.viewmodel

import androidx.lifecycle.viewModelScope
import com.template.cleanlibrary.core.common.base.BaseViewModel
import com.template.cleanlibrary.core.domain.usecase.GetSecondTitleUseCase
import kotlinx.coroutines.launch
import org.orbitmvi.orbit.syntax.simple.intent
import org.orbitmvi.orbit.syntax.simple.reduce

class BookDetailsViewModel(
    getSecondTitleUseCase: GetSecondTitleUseCase // TODO ("Exchange with book details usecase")
) : BaseViewModel<BookDetailsViewModel.State, BookDetailsViewModel.SideEffect>(State()) {

    init {
        viewModelScope.launch {
            getSecondTitleUseCase.invoke(Unit).onSuccess {
                intent {
                    reduce { state.copy(title = it) }
                }
            }
        }
    }

    fun sendAction(action: Action) {
    }

    sealed class SideEffect {
        data class ShowError(val message: String?) : SideEffect()
    }

    sealed class Action {

    }

    data class State(
        val title: String = "",
    )
}