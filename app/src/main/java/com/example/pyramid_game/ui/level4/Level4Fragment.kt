package com.example.pyramid_game.ui.level4

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.pyramid_game.R

class Level4Fragment : Fragment() {

    companion object {
        fun newInstance() = Level4Fragment()
    }

    private lateinit var viewModel: Level4ViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_level4, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(Level4ViewModel::class.java)
        // TODO: Use the ViewModel
    }

}