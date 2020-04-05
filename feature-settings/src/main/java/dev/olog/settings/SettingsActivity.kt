package dev.olog.settings

import android.os.Bundle
import dagger.android.support.DaggerAppCompatActivity
import dev.olog.core.gateway.Repository
import kotlinx.android.synthetic.main.activity_settings.*
import javax.inject.Inject

class SettingsActivity : DaggerAppCompatActivity(R.layout.activity_settings) {

    @Inject
    lateinit var repository: Repository

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        repo.text = repository.toString()
    }
}