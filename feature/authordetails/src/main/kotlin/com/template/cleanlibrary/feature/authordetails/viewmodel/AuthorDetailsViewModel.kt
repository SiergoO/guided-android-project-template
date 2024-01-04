package com.template.cleanlibrary.feature.authordetails.viewmodel

import com.template.cleanlibrary.core.common.base.BaseViewModel

class AuthorDetailsViewModel : BaseViewModel<AuthorDetailsViewModel.State, AuthorDetailsViewModel.SideEffect>(State()) {

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