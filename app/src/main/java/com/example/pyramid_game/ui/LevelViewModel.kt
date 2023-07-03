package com.example.pyramid_game.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.pyramid_game.utils.Levels
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LevelViewModel @Inject constructor() : ViewModel() {
    private val _stateLevel = MutableStateFlow<Levels>(Levels.L1)
    val stateLevel: StateFlow<Levels> = _stateLevel

    fun loadState(levels: Levels) {
        viewModelScope.launch(Dispatchers.IO) {
            _stateLevel.emit(levels)
        }
    }
}