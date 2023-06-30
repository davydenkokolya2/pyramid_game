package com.example.pyramid_game.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.pyramid_game.utils.Screens
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ScreenViewModel @Inject constructor() : ViewModel() {
    private val _stateScreen = MutableStateFlow<Screens?>(null)
    val stateScreen: StateFlow<Screens?> = _stateScreen

    fun loadState(screens: Screens) {
        viewModelScope.launch(Dispatchers.IO) {
            _stateScreen.emit(screens)
        }
    }
}