package dev.olog.feature.main

import android.os.Bundle
import androidx.fragment.app.commit
import dagger.hilt.android.AndroidEntryPoint
import dev.olog.feature.main.home.HomeFragment
import dev.olog.feature.presentation.base.BaseActivity
import dev.olog.navigation.screens.FragmentScreen

@AndroidEntryPoint
class MainActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if (savedInstanceState == null) {
            showHomeFragment()
        }

    }

    private fun showHomeFragment() {
        supportFragmentManager.commit {
            setReorderingAllowed(true)
            replace(R.id.fragmentContainer, HomeFragment(), FragmentScreen.HOME.tag)
        }
    }

}
