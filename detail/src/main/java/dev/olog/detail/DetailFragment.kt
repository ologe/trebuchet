package dev.olog.detail

import android.content.Context
import android.os.Bundle
import android.view.View
import androidx.annotation.Keep
import androidx.fragment.app.Fragment
import dev.olog.core.dagger.injectable.InjectableComponent
import dev.olog.core.dagger.subComponentBuilder
import dev.olog.core.gateway.Repository
import dev.olog.intents.Params
import kotlinx.android.synthetic.main.activity_detail.*
import javax.inject.Inject

@Keep
class DetailFragment : Fragment(R.layout.fragment_detail),
    InjectableComponent {

    @Inject
    lateinit var repository: Repository

    override fun onAttach(context: Context) {
        subComponentBuilder<DetailScreenDagger.DetailSubComponent.Factory>(context)
            .create()
            .inject(this)
        super.onAttach(context)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val id = arguments!!.getInt(Params.LISTING_ID)

        listingId.text = "listing id $id"
        repo.text = repository.toString()
    }

}