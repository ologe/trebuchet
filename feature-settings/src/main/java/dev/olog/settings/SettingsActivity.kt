package dev.olog.settings

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import dev.olog.core.dagger.injectable.InjectableComponent
import dev.olog.core.gateway.Repository
import dev.olog.settings.dagger.inject
import kotlinx.android.synthetic.main.activity_settings.*
import javax.inject.Inject

class SettingsActivity : AppCompatActivity(R.layout.activity_settings),
    InjectableComponent {

    @Inject
    lateinit var repository: Repository

    override fun onCreate(savedInstanceState: Bundle?) {
        inject()
        super.onCreate(savedInstanceState)

        repo.text = repository.toString()
    }
}