package dev.olog.feature.settings

import android.os.Bundle
import dev.olog.feature.presentation.base.AppPreferences
import dev.olog.feature.presentation.base.BaseActivity
import kotlinx.android.synthetic.main.activity_settings.*
import javax.inject.Inject

class SettingsActivity : BaseActivity() {

    @Inject
    internal lateinit var appPreferences: AppPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_settings)

        darkMode.setOnClickListener {
            appPreferences.setDarkMode(!appPreferences.isDarkMode())
            recreate()
        }
    }

}