package dev.olog.main

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import dev.olog.core.dagger.injectable.InjectableComponent
import dev.olog.core.dagger.subComponentBuilder
import dev.olog.core.gateway.Repository
import dev.olog.intents.Activities
import kotlinx.android.synthetic.main.activity_main.*
import javax.inject.Inject

class MainActivity : AppCompatActivity(R.layout.activity_main),
    InjectableComponent {

    @Inject
    lateinit var repository: Repository

    override fun onCreate(savedInstanceState: Bundle?) {
        subComponentBuilder<MainScreenDagger.MainSubComponent.Builder>(this)
            .build()
            .inject(this)

        super.onCreate(savedInstanceState)

        repo.text = repository.toString()

        detail.setOnClickListener {
            startActivity(Activities.toDetail(this, 1))
        }

        settings.setOnClickListener {
            startActivity(Activities.toSettings(this))
        }
    }

}
