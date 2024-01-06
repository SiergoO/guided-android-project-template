package com.template.cleanlibrary.feature.authordetails.viewmodel

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.viewModelScope
import com.template.cleanlibrary.core.common.base.BaseViewModel
import com.template.cleanlibrary.feature.authordetails.navigation.AuthorArgs
import kotlinx.coroutines.launch
import org.orbitmvi.orbit.syntax.simple.intent
import org.orbitmvi.orbit.syntax.simple.reduce

class AuthorDetailsViewModel(
    savedStateHandle: SavedStateHandle
) : BaseViewModel<AuthorDetailsViewModel.State, AuthorDetailsViewModel.SideEffect>(State()) {

    private val authorArgs: AuthorArgs = AuthorArgs(savedStateHandle)
    private val authorId: String = authorArgs.authorId

    init {
        viewModelScope.launch {
            intent {
                reduce { state.copy(authorId = authorId) }
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
        val authorId: String = "",
    )
}