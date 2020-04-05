package dev.olog.detail

import android.os.Bundle
import android.view.View
import androidx.annotation.Keep
import dagger.android.support.DaggerFragment
import dev.olog.core.gateway.Repository
import dev.olog.navigation.Params
import kotlinx.android.synthetic.main.activity_detail.*
import javax.inject.Inject

@Keep
class DetailFragment : DaggerFragment(R.layout.fragment_detail) {

    @Inject
    lateinit var repository: Repository

    @Inject
    lateinit var string: String

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val id = requireArguments().getLong(Params.LISTING_ID)

        println(string)

        listingId.text = "listing id $id"
        repo.text = repository.toString()
    }

}