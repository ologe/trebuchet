package dev.olog.feature.main

import android.os.Bundle
import androidx.activity.viewModels
import dagger.hilt.android.AndroidEntryPoint
import dev.olog.feature.presentation.base.BaseActivity

@AndroidEntryPoint
class MainActivity : BaseActivity() {

    private val viewModel: MainActivityViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if (savedInstanceState == null) {
            if (viewModel.isLogged()) {
                viewModel.navigateToMain(this)
            } else {
                viewModel.navigateToLogin(this)
            }
        }

    }

}
