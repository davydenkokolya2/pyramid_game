package com.example.pyramid_game.ui.level5

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.pyramid_game.R

class Lavel5Fragment : Fragment() {

    companion object {
        fun newInstance() = Lavel5Fragment()
    }

    private lateinit var viewModel: Lavel5ViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_lavel5, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(Lavel5ViewModel::class.java)
        // TODO: Use the ViewModel
    }

}