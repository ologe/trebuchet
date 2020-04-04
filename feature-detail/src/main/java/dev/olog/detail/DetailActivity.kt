package dev.olog.detail

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import dev.olog.core.dagger.injectable.InjectableComponent
import dev.olog.core.dagger.daggerFactory
import dev.olog.core.gateway.Repository
import dev.olog.detail.dagger.DetailScreenDagger
import dev.olog.detail.dagger.inject
import dev.olog.navigation.Navigator
import dev.olog.navigation.Params
import kotlinx.android.synthetic.main.activity_detail.*
import javax.inject.Inject

class DetailActivity : AppCompatActivity(R.layout.activity_detail),
    InjectableComponent {

    @Inject
    lateinit var repository: Repository

    @Inject
    lateinit var navigator: Navigator

    override fun onCreate(savedInstanceState: Bundle?) {
        inject()
        super.onCreate(savedInstanceState)

        val id = intent.extras!!.getLong(Params.LISTING_ID)

        listingId.text = "listing id $id"
        repo.text = repository.toString()

        // for the sake of the example
        navigator.toDetailFragment(this, id) { f ->
            replace(R.id.fragmentContainer, f, "tag")
        }
    }

}