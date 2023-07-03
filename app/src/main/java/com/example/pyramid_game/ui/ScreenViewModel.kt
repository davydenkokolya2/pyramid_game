package com.example.pyramid_game.ui

import android.graphics.Outline
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.ViewOutlineProvider
import android.widget.RadioButton
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.recyclerview.widget.RecyclerView
import com.example.pyramid_game.R
import com.example.pyramid_game.utils.Levels
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

    class PositionAdapter(matchList: ArrayList<Levels>, val onItemClick: (View, Levels) -> Unit) :
        RecyclerView.Adapter<PositionAdapter.PositionViewHolder>() {


        var positionList: List<Levels> = matchList
            set(value) {
                field = value
            }
        private var lastSelectedPosition = 1

        override fun onCreateViewHolder(
            parent: ViewGroup,
            viewType: Int
        ): PositionViewHolder {
            val itemView =
                LayoutInflater.from(parent.context).inflate(R.layout.fragment_level4, parent, false)
            return PositionViewHolder(itemView)
        }

        override fun onBindViewHolder(holder: PositionViewHolder, position: Int) {
            val currentItem = positionList[position]
            holder.type.text = currentItem.toString()
            holder.type.setOnClickListener {
                lastSelectedPosition = holder.adapterPosition
                onItemClick(it, currentItem)
                notifyDataSetChanged()
            }
            holder.type.isChecked = lastSelectedPosition == position
        }

        override fun getItemCount(): Int {
            return positionList.size
        }

        class PositionViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
            val type: RadioButton = itemView.findViewById(R.id.btnLevel4)
        }
    }
}