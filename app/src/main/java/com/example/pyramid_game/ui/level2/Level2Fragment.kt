package com.example.pyramid_game.ui.level2

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.activityViewModels
import com.example.pyramid_game.ui.you_luse_pop_up.YouLusePopUpFragment
import com.example.pyramid_game.databinding.FragmentLevel2Binding
import com.example.pyramid_game.ui.LevelViewModel
import com.example.pyramid_game.ui.ScreenViewModel
import com.example.pyramid_game.utils.Levels
import com.example.pyramid_game.utils.Screens

class Level2Fragment : Fragment() {

    companion object {
        fun newInstance() = Level2Fragment()
    }

    private lateinit var viewModel: Level2ViewModel
    private lateinit var binding: FragmentLevel2Binding
    private val screenViewModel: ScreenViewModel by activityViewModels()
    private val levelViewModel: LevelViewModel by activityViewModels()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentLevel2Binding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(Level2ViewModel::class.java)
        binding.btn2Level2.setOnClickListener {
            levelViewModel.loadState(Levels.L3)
            screenViewModel.loadState(Screens.SCORE)
        }
        binding.btn1Level2.setOnClickListener {
            showPopUp()
        }
        binding.btn3Level2.setOnClickListener {
            showPopUp()
        }
        binding.btn4Level2.setOnClickListener {
            showPopUp()
        }
    }

    fun showPopUp(){
        YouLusePopUpFragment().show(
            (activity as AppCompatActivity).supportFragmentManager,
            "showPopUp"
        )
    }
}