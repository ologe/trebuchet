package dev.olog.main

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import dev.olog.core.dagger.injectable.InjectableComponent
import dev.olog.core.gateway.Repository
import dev.olog.core.dagger.subComponentBuilder
import javax.inject.Inject

class MainActivity : AppCompatActivity(R.layout.activity_main),
    InjectableComponent {

    @Inject
    lateinit var repository: Repository

    override fun onCreate(savedInstanceState: Bundle?) {
        subComponentBuilder<MainScreenDagger.MainSubComponent.Builder>()
            .build()
            .inject(this)

        super.onCreate(savedInstanceState)

        println(repository)
    }

    override val context: Context = this
}
