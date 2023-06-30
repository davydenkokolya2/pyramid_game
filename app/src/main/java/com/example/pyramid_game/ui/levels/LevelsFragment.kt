package com.example.pyramid_game.ui.levels

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.ViewModelProvider
import com.example.pyramid_game.databinding.FragmentLevelsBinding
import com.example.pyramid_game.ui.ScreenViewModel
import com.example.pyramid_game.utils.Screens

class LevelsFragment : Fragment() {

    companion object {
        fun newInstance() = LevelsFragment()
    }

    private lateinit var viewModel: LevelsViewModel
    private lateinit var binding: FragmentLevelsBinding
    private val screenViewModel: ScreenViewModel by activityViewModels()
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
    }

}