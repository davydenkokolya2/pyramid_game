package com.example.pyramid_game.ui.pop_up_lock

import android.app.Dialog
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.activityViewModels
import com.example.pyramid_game.databinding.FragmentPopUpLockBinding
import com.example.pyramid_game.ui.ScreenViewModel
import com.example.pyramid_game.utils.Screens

class PopUpLockFragment : DialogFragment() {

    companion object {
        fun newInstance() = PopUpLockFragment()
    }

    private lateinit var viewModel: PopUpLockViewModel
    private lateinit var binding: FragmentPopUpLockBinding
    private val screenViewModel: ScreenViewModel by activityViewModels()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentPopUpLockBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val dialog = super.onCreateDialog(savedInstanceState)
        dialog.setCanceledOnTouchOutside(false)
        return dialog
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(PopUpLockViewModel::class.java)
        dialog?.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        binding.imageView5.setOnClickListener {
            screenViewModel.loadState(Screens.MAINMENU)
            dismiss()
        }
    }

}