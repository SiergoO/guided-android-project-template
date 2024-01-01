package com.cleanlibrary.common.base

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.CoroutineScope
import org.orbitmvi.orbit.Container
import org.orbitmvi.orbit.ContainerHost
import org.orbitmvi.orbit.container

abstract class BaseViewModel<STATE : Any, SIDE_EFFECT : Any>(initialState: STATE) :
    ContainerHost<STATE, SIDE_EFFECT>, ViewModel() {

    private val scope: CoroutineScope = viewModelScope
    override val container: Container<STATE, SIDE_EFFECT> = scope.container(initialState)
}