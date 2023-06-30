package com.example.pyramid_game.ui.colour_info

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.pyramid_game.R

class ColourInfoFragment : Fragment() {

    companion object {
        fun newInstance() = ColourInfoFragment()
    }

    private lateinit var viewModel: ColourInfoViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_colour_info, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(ColourInfoViewModel::class.java)
        // TODO: Use the ViewModel
    }

}