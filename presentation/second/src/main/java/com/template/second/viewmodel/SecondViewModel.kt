package com.template.second.viewmodel

import androidx.lifecycle.viewModelScope
import com.template.common.base.BaseViewModel
import com.template.domain.usecase.GetSecondTitleUseCase
import kotlinx.coroutines.launch
import org.orbitmvi.orbit.syntax.simple.intent
import org.orbitmvi.orbit.syntax.simple.reduce

class SecondViewModel(
    getSecondTitleUseCase: GetSecondTitleUseCase
) : BaseViewModel<SecondViewModel.State, SecondViewModel.SideEffect>(State()) {

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