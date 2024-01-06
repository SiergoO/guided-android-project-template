package com.template.cleanlibrary

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.template.cleanlibrary.MainActivityUiState.Loading
import com.template.cleanlibrary.MainActivityUiState.Success
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class MainActivityViewModel : ViewModel() {
    private val _uiState: MutableStateFlow<MainActivityUiState> = MutableStateFlow(Loading)
    val uiState: StateFlow<MainActivityUiState> = _uiState.asStateFlow()

    init {
        viewModelScope.launch {
            // TODO("Replace with app initialisation action")
            delay(3_000)
            _uiState.emit(Success)
        }
    }
}

sealed interface MainActivityUiState {
    data object Loading : MainActivityUiState
    data object Success : MainActivityUiState
}