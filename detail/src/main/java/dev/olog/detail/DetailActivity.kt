package dev.olog.detail

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import dev.olog.core.dagger.injectable.InjectableComponent
import dev.olog.core.dagger.subComponentBuilder
import dev.olog.core.gateway.Repository
import dev.olog.intents.Fragments
import dev.olog.intents.Params
import kotlinx.android.synthetic.main.activity_detail.*
import javax.inject.Inject

class DetailActivity : AppCompatActivity(R.layout.activity_detail),
    InjectableComponent {

    @Inject
    lateinit var repository: Repository

    override fun onCreate(savedInstanceState: Bundle?) {
        subComponentBuilder<DetailScreenDagger.DetailSubComponent.Builder>(this).build()
            .inject(this)

        super.onCreate(savedInstanceState)

        val id = intent.extras!!.getInt(Params.LISTING_ID)

        listingId.text = "listing id $id"
        repo.text = repository.toString()

        // for the sake of the example
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragmentContainer, Fragments.toDetailFragment(id)!!)
            .commit()
    }

}