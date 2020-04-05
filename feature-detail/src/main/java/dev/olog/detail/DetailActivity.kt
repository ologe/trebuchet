package dev.olog.detail

import android.os.Bundle
import dagger.android.support.DaggerAppCompatActivity
import dev.olog.core.gateway.Repository
import dev.olog.navigation.Navigator
import dev.olog.navigation.Params
import kotlinx.android.synthetic.main.activity_detail.*
import javax.inject.Inject

class DetailActivity : DaggerAppCompatActivity(R.layout.activity_detail){

    @Inject
    lateinit var repository: Repository

    @Inject
    lateinit var navigator: Navigator

    override fun onCreate(savedInstanceState: Bundle?) {
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