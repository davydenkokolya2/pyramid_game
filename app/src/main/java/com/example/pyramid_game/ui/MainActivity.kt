package com.example.pyramid_game.ui

import android.media.AudioManager
import android.media.MediaPlayer
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import com.example.pyramid_game.R
import com.example.pyramid_game.databinding.ActivityMainBinding
import com.example.pyramid_game.ui.colour_info.ColourInfoFragment
import com.example.pyramid_game.ui.level1.Level1Fragment
import com.example.pyramid_game.ui.level2.Level2Fragment
import com.example.pyramid_game.ui.level3.Level3Fragment
import com.example.pyramid_game.ui.level4.Level4Fragment
import com.example.pyramid_game.ui.level5.Level5Fragment
import com.example.pyramid_game.ui.levels.LevelsFragment
import com.example.pyramid_game.ui.members.MembersFragment
import com.example.pyramid_game.ui.menu.MenuFragment
import com.example.pyramid_game.ui.score.ScoreFragment
import com.example.pyramid_game.ui.settings.SettingsFragment
import com.example.pyramid_game.ui.settings.SettingsViewModel
import com.example.pyramid_game.ui.start.StartFragment
import com.example.pyramid_game.utils.Levels
import com.example.pyramid_game.utils.Screens
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val screenViewModel: ScreenViewModel by viewModels()
    private val levelViewModel: LevelViewModel by viewModels()
    private val settingsViewModel: SettingsViewModel by viewModels()
    private lateinit var mediaPlayer: MediaPlayer
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(LayoutInflater.from(this))
        setContentView(binding.root)

        val audioManager = applicationContext.getSystemService(AUDIO_SERVICE) as AudioManager


        mediaPlayer = MediaPlayer.create(this, R.raw.water)
        mediaPlayer.isLooping = true
        lifecycleScope.launch {
            settingsViewModel.stateVolume.collect {
                Log.d("test", it.toString())

                mediaPlayer.setVolume(it / 100, it / 100)

            }
        }

        lifecycleScope.launch {
            screenViewModel.stateScreen.collect {
                Log.d("test", it.toString())
                when (it) {
                    Screens.SETTINGS -> replaceFragment(SettingsFragment())
                    Screens.LEVELS -> replaceFragment(LevelsFragment())
                    Screens.START -> replaceFragment(StartFragment())
                    Screens.MEMBERS -> replaceFragment(MembersFragment())
                    Screens.COLOURINFO -> replaceFragment(ColourInfoFragment())
                    Screens.MAINMENU -> replaceFragment(MenuFragment())
                    Screens.SCORE -> replaceFragment(ScoreFragment())
                    else -> {}
                }
            }
        }
    }

    override fun onResume() {
        super.onResume()
        mediaPlayer.start()
    }

    private fun replaceFragment(fragment: Fragment) {
        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.fragmentContainerView, fragment)
        fragmentTransaction.commit()
    }

    override fun onStop() {
        super.onStop()
        //mediaPlayer.release()
        mediaPlayer.pause()
    }
}