package com.example.pyramid_game.ui.settings

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class SettingsViewModel : ViewModel() {
    private val _stateVolume = MutableStateFlow<Float>(0F)
    val stateVolume: StateFlow<Float> = _stateVolume

    fun loadState(volume: Float) {
        viewModelScope.launch(Dispatchers.IO) {
            _stateVolume.emit(volume)
        }
    }
}