package com.template.first.viewmodel

import com.template.common.base.BaseViewModel
import org.orbitmvi.orbit.syntax.simple.intent
import org.orbitmvi.orbit.syntax.simple.postSideEffect

class SecondViewModel(

) : BaseViewModel<SecondViewModel.State, SecondViewModel.SideEffect>(State()) {

    fun sendAction(action: Action) {
    }

    sealed class SideEffect {
        data class ShowError(val message: String?) : SideEffect()
    }

    sealed class Action {

    }

    data class State(
        val title: String = "Second",
    )
}