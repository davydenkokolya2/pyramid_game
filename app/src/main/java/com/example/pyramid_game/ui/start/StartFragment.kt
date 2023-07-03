package com.example.pyramid_game.ui.start

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.lifecycleScope
import com.example.pyramid_game.R
import com.example.pyramid_game.databinding.FragmentLevel1Binding
import com.example.pyramid_game.databinding.FragmentStartBinding
import com.example.pyramid_game.ui.LevelViewModel
import com.example.pyramid_game.ui.ScreenViewModel
import com.example.pyramid_game.ui.level1.Level1Fragment
import com.example.pyramid_game.ui.level2.Level2Fragment
import com.example.pyramid_game.ui.level3.Level3Fragment
import com.example.pyramid_game.ui.level4.Level4Fragment
import com.example.pyramid_game.ui.level5.Level5Fragment
import com.example.pyramid_game.utils.Levels
import com.example.pyramid_game.utils.Screens
import kotlinx.coroutines.launch

class StartFragment : Fragment() {

    companion object {
        fun newInstance() = StartFragment()
    }

    private lateinit var viewModel: StartViewModel
    private lateinit var binding: FragmentStartBinding
    private val screenViewModel: ScreenViewModel by activityViewModels()
    private val levelViewModel: LevelViewModel by activityViewModels()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentStartBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(StartViewModel::class.java)
        binding.btnHome.setOnClickListener {
            screenViewModel.loadState(Screens.MAINMENU)
        }
        lifecycleScope.launch {
            levelViewModel.stateLevel.collect {
                Log.d("test", it.toString())
                when(it) {
                    Levels.L1 -> replaceFragment(Level1Fragment())
                    Levels.L2 -> replaceFragment(Level2Fragment())
                    Levels.L3 -> replaceFragment(Level3Fragment())
                    Levels.L4 -> replaceFragment(Level4Fragment())
                    Levels.L5 -> replaceFragment(Level5Fragment())
                    else -> {}
                }
            }
        }
    }
    private fun replaceFragment(fragment: Fragment) {
        val fragmentManager = requireActivity().supportFragmentManager
        Log.d("test", "replace")
        val fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.fragmentContainerView2, fragment)
        fragmentTransaction.commit()
    }

}