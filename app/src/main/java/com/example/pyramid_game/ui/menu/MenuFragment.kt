package com.example.pyramid_game.ui.menu

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.ViewModelProvider
import com.example.pyramid_game.databinding.FragmentMenuBinding
import com.example.pyramid_game.ui.ScreenViewModel
import com.example.pyramid_game.utils.Screens

class MenuFragment : Fragment() {

    companion object {
        fun newInstance() = MenuFragment()
    }

    private lateinit var viewModel: MenuViewModel
    private lateinit var binding: FragmentMenuBinding
    private val screenViewModel: ScreenViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentMenuBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(MenuViewModel::class.java)
        binding.btnSettings.setOnClickListener {
            screenViewModel.loadState(Screens.SETTINGS)
        }
        binding.btnLevels.setOnClickListener {
            screenViewModel.loadState(Screens.LEVELS)
        }
        binding.btnRules.setOnClickListener {
            screenViewModel.loadState(Screens.RULES)
        }
        binding.btnStart.setOnClickListener {
            screenViewModel.loadState(Screens.START)
        }
        binding.btnMembers.setOnClickListener {
            screenViewModel.loadState(Screens.MEMBERS)
        }
        binding.btnColourInfo.setOnClickListener {
            screenViewModel.loadState(Screens.COLOURINFO)
        }
    }

}