package com.template.cleanlibrary.feature.first.viewmodel

import androidx.lifecycle.viewModelScope
import com.template.cleanlibrary.core.common.base.BaseViewModel
import com.template.cleanlibrary.core.domain.usecase.GetFirstTitleUseCase
import kotlinx.coroutines.launch
import org.orbitmvi.orbit.syntax.simple.intent
import org.orbitmvi.orbit.syntax.simple.postSideEffect
import org.orbitmvi.orbit.syntax.simple.reduce

class FirstViewModel(
    getFirstTitleUse: GetFirstTitleUseCase
) : BaseViewModel<FirstViewModel.State, FirstViewModel.SideEffect>(State()) {

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
            is Action.ShowSecondScreenClicked -> {
                intent {
                    postSideEffect(SideEffect.NavigateToSecondScreen)
                }
            }
        }
    }

    sealed class SideEffect {
        object NavigateToSecondScreen : SideEffect()
        data class ShowError(val message: String?) : SideEffect()
    }

    sealed class Action {
        object ShowSecondScreenClicked : Action()
    }

    data class State(
        val title: String = "",
    )
}