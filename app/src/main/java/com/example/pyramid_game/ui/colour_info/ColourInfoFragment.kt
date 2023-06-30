package com.example.pyramid_game.ui.colour_info

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.ViewModelProvider
import com.example.pyramid_game.databinding.FragmentColourInfoBinding
import com.example.pyramid_game.ui.ScreenViewModel
import com.example.pyramid_game.utils.Screens

class ColourInfoFragment : Fragment() {

    companion object {
        fun newInstance() = ColourInfoFragment()
    }
    private lateinit var binding: FragmentColourInfoBinding
    private val screenViewModel: ScreenViewModel by activityViewModels()
    private lateinit var viewModel: ColourInfoViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentColourInfoBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(ColourInfoViewModel::class.java)
        binding.btnHome.setOnClickListener {
            screenViewModel.loadState(Screens.MAINMENU)
        }
    }

}