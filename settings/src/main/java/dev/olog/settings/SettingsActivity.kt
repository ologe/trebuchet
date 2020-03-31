package dev.olog.settings

import android.content.Context
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import dev.olog.core.dagger.injectable.InjectableComponent

class SettingsActivity : AppCompatActivity(R.layout.activity_settings),
    InjectableComponent {

    override fun onCreate(savedInstanceState: Bundle?) {
        // TODO dagger
        super.onCreate(savedInstanceState)
    }

    override val context: Context = this
}