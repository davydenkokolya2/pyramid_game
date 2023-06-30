package com.example.pyramid_game.ui.levels

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.pyramid_game.R

class LevelsFragment : Fragment() {

    companion object {
        fun newInstance() = LevelsFragment()
    }

    private lateinit var viewModel: LevelsViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_levels, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(LevelsViewModel::class.java)
        // TODO: Use the ViewModel
    }

}