package dev.olog.settings

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import dev.olog.core.dagger.injectable.InjectableComponent
import dev.olog.core.dagger.subComponentBuilder
import dev.olog.core.gateway.Repository
import kotlinx.android.synthetic.main.activity_settings.*
import javax.inject.Inject

class SettingsActivity : AppCompatActivity(R.layout.activity_settings),
    InjectableComponent {

    @Inject
    lateinit var repository: Repository

    override fun onCreate(savedInstanceState: Bundle?) {
        subComponentBuilder<SettingsScreenDagger.SettingsSubComponent.Factory>(this)
            .create(this)
            .inject(this)

        super.onCreate(savedInstanceState)

        repo.text = repository.toString()
    }
}