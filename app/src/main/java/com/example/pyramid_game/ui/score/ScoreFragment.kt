package com.example.pyramid_game.ui.score

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import com.example.pyramid_game.databinding.FragmentScoreBinding
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

class ScoreFragment : Fragment() {

    companion object {
        fun newInstance() = ScoreFragment()
    }

    private lateinit var binding: FragmentScoreBinding
    private val screenViewModel: ScreenViewModel by activityViewModels()
    private lateinit var viewModel: ScoreViewModel
    private val levelViewModel: LevelViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentScoreBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(ScoreViewModel::class.java)
        binding.btnHome.setOnClickListener {
            screenViewModel.loadState(Screens.MAINMENU)
        }
        binding.imageView11.setOnClickListener {
            /*lifecycleScope.launch {
                levelViewModel.stateLevel.collect {
                    when(it) {
                        Levels.L1 -> levelViewModel.loadState(Levels.L2)
                        Levels.L2 -> levelViewModel.loadState(Levels.L3)
                        Levels.L3 -> levelViewModel.loadState(Levels.L4)
                        Levels.L4 -> levelViewModel.loadState(Levels.L5)

                        else -> {}
                    }

                }
            }*/
            screenViewModel.loadState(Screens.START)
        }

    }

}