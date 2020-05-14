package dev.olog.feature.main

import android.os.Bundle
import dev.olog.feature.presentation.base.BaseActivity
import javax.inject.Inject

class MainActivity : BaseActivity() {

    @Inject
    internal lateinit var controller: MainActivityController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if (savedInstanceState == null) {
            if (controller.isLogged()) {
                controller.navigateToMain(this)
            } else {
                controller.navigateToLogin(this)
            }
        }

    }

}
