package com.example.pyramid_game.ui.levels

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.ViewModelProvider
import com.example.pyramid_game.ui.pop_up_lock.PopUpLockFragment
import com.example.pyramid_game.databinding.FragmentLevelsBinding
import com.example.pyramid_game.ui.LevelViewModel
import com.example.pyramid_game.ui.ScreenViewModel
import com.example.pyramid_game.utils.Levels
import com.example.pyramid_game.utils.Screens

class LevelsFragment : Fragment() {

    companion object {
        fun newInstance() = LevelsFragment()
    }

    private lateinit var viewModel: LevelsViewModel
    private lateinit var binding: FragmentLevelsBinding
    private val screenViewModel: ScreenViewModel by activityViewModels()
    private val levelViewModel: LevelViewModel by activityViewModels()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentLevelsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(LevelsViewModel::class.java)
        binding.btnHome.setOnClickListener {
            screenViewModel.loadState(Screens.MAINMENU)
        }
        binding.btnLevel1.setOnClickListener {
            screenViewModel.loadState(Screens.START)

        }
        binding.btnLevel2.setOnClickListener {
            if (levelViewModel.stateLevel.value.ordinal > 1)
            {
                levelViewModel.loadState(Levels.L2)
                screenViewModel.loadState(Screens.START)
            }
            else
                showPopUp()
        }
        binding.btnLevel3.setOnClickListener {
            if (levelViewModel.stateLevel.value.ordinal > 2)
            {
                levelViewModel.loadState(Levels.L3)
                screenViewModel.loadState(Screens.START)
            }
            else
                showPopUp()
        }
        binding.btnLevel4.setOnClickListener {
            if (levelViewModel.stateLevel.value.ordinal > 3)
            {
                levelViewModel.loadState(Levels.L4)
                screenViewModel.loadState(Screens.START)
            }
            else
                showPopUp()
        }
        binding.btnLevel5.setOnClickListener {
            if (levelViewModel.stateLevel.value.ordinal > 4)
            {
                levelViewModel.loadState(Levels.L5)
                screenViewModel.loadState(Screens.START)
            }
            else
                showPopUp()
        }
    }

    fun showPopUp() {
        PopUpLockFragment().show(
            (activity as AppCompatActivity).supportFragmentManager,
            "showPopUp"
        )
    }
}