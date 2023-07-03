package com.example.pyramid_game.ui.you_luse_pop_up

import android.app.Dialog
import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.activityViewModels
import com.example.pyramid_game.R
import com.example.pyramid_game.databinding.FragmentLevel1Binding
import com.example.pyramid_game.databinding.FragmentYouLusePopUpBinding
import com.example.pyramid_game.ui.ScreenViewModel
import com.example.pyramid_game.utils.Screens

class YouLusePopUpFragment : DialogFragment() {

    companion object {
        fun newInstance() = YouLusePopUpFragment()
    }

    private lateinit var viewModel: YouLusePopUpViewModel
    private lateinit var binding: FragmentYouLusePopUpBinding
    private val screenViewModel: ScreenViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentYouLusePopUpBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val dialog = super.onCreateDialog(savedInstanceState)
        dialog.setCanceledOnTouchOutside(false)
        return dialog
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(YouLusePopUpViewModel::class.java)
        binding.btnGoHome.setOnClickListener {
            screenViewModel.loadState(Screens.MAINMENU)
            dismiss()
        }
        binding.btnRestartLevel.setOnClickListener {
            screenViewModel.loadState(Screens.START)
            dismiss()
        }
    }

}