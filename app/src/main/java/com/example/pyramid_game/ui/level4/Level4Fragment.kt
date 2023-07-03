package com.example.pyramid_game.ui.level4

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.activityViewModels
import com.example.pyramid_game.R
import com.example.pyramid_game.databinding.FragmentLevel3Binding
import com.example.pyramid_game.databinding.FragmentLevel4Binding
import com.example.pyramid_game.ui.LevelViewModel
import com.example.pyramid_game.ui.ScreenViewModel
import com.example.pyramid_game.ui.you_luse_pop_up.YouLusePopUpFragment
import com.example.pyramid_game.utils.Levels
import com.example.pyramid_game.utils.Screens

class Level4Fragment : Fragment() {

    companion object {
        fun newInstance() = Level4Fragment()
    }

    private lateinit var viewModel: Level4ViewModel
    private lateinit var binding: FragmentLevel4Binding
    private val screenViewModel: ScreenViewModel by activityViewModels()
    private val levelViewModel: LevelViewModel by activityViewModels()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentLevel4Binding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(Level4ViewModel::class.java)
        binding.btn3Level4.setOnClickListener {
            levelViewModel.loadState(Levels.L5)
            screenViewModel.loadState(Screens.SCORE)
        }
        binding.btn1Level4.setOnClickListener {
            showPopUp()
        }
        binding.btn2Level4.setOnClickListener {
            showPopUp()
        }
        binding.btn4Level4.setOnClickListener {
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