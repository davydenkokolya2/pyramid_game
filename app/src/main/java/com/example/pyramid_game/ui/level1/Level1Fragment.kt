package com.example.pyramid_game.ui.level1

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.activityViewModels
import com.example.pyramid_game.R
import com.example.pyramid_game.databinding.FragmentLevel1Binding
import com.example.pyramid_game.ui.LevelViewModel
import com.example.pyramid_game.ui.ScreenViewModel
import com.example.pyramid_game.ui.you_luse_pop_up.YouLusePopUpFragment
import com.example.pyramid_game.utils.Levels
import com.example.pyramid_game.utils.Screens

class Level1Fragment : Fragment() {

    companion object {
        fun newInstance() = Level1Fragment()
    }

    private lateinit var viewModel: Level1ViewModel
    private lateinit var binding: FragmentLevel1Binding
    private val screenViewModel: ScreenViewModel by activityViewModels()
    private val levelViewModel: LevelViewModel by activityViewModels()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentLevel1Binding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(Level1ViewModel::class.java)
        binding.btn1Level1.setOnClickListener {
            Log.d("test", "click")
            levelViewModel.loadState(Levels.L2)
            screenViewModel.loadState(Screens.SCORE)
        }
        binding.btn2Level1.setOnClickListener {
            showPopUp()
        }
        binding.btn3Level1.setOnClickListener {
            showPopUp()
        }
        binding.btn4Level1.setOnClickListener {
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