package com.example.pyramid_game.ui

import android.os.Bundle
import android.view.LayoutInflater
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import com.example.pyramid_game.R
import com.example.pyramid_game.databinding.ActivityMainBinding
import com.example.pyramid_game.ui.colour_info.ColourInfoFragment
import com.example.pyramid_game.ui.levels.LevelsFragment
import com.example.pyramid_game.ui.members.MembersFragment
import com.example.pyramid_game.ui.menu.MenuFragment
import com.example.pyramid_game.ui.settings.SettingsFragment
import com.example.pyramid_game.ui.start.StartFragment
import com.example.pyramid_game.utils.Screens
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val screenViewModel: ScreenViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(LayoutInflater.from(this))
        setContentView(binding.root)

        lifecycleScope.launch {
            screenViewModel.stateScreen.collect {
                when(it) {
                    Screens.SETTINGS -> replaceFragment(SettingsFragment())
                    Screens.LEVELS -> replaceFragment(LevelsFragment())
                    Screens.START -> replaceFragment(StartFragment())
                    Screens.MEMBERS -> replaceFragment(MembersFragment())
                    Screens.COLOURINFO -> replaceFragment(ColourInfoFragment())
                    Screens.MAINMENU -> replaceFragment(MenuFragment())
                    else -> {}
                }
            }
        }
    }

    private fun replaceFragment(fragment: Fragment) {
        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.fragmentContainerView, fragment)
        fragmentTransaction.commit()
    }
}