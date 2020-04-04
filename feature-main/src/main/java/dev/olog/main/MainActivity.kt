package dev.olog.main

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import dev.olog.core.dagger.injectable.InjectableComponent
import dev.olog.core.gateway.Repository
import dev.olog.main.dagger.inject
import dev.olog.navigation.Navigator
import kotlinx.android.synthetic.main.activity_main.*
import javax.inject.Inject

class MainActivity : AppCompatActivity(R.layout.activity_main),
    InjectableComponent {

    @Inject
    lateinit var repository: Repository

    // just to test that module injection works
    @Inject
    lateinit var act: MainActivity

    @Inject
    lateinit var navigator: Navigator

    override fun onCreate(savedInstanceState: Bundle?) {
        inject()
        super.onCreate(savedInstanceState)

        repo.text = repository.toString()

        detail.setOnClickListener {
            navigator.toDetail(this, 101)
        }

        settings.setOnClickListener {
            navigator.toSettings(this)
        }
    }

}
