package com.template.first.viewmodel

import com.template.common.base.BaseViewModel
import org.orbitmvi.orbit.syntax.simple.intent
import org.orbitmvi.orbit.syntax.simple.postSideEffect

class FirstViewModel(

) : BaseViewModel<FirstViewModel.State, FirstViewModel.SideEffect>(State()) {

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
        val title: String = "First",
    )
}