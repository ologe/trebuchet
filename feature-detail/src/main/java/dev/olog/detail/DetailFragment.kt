package dev.olog.detail

import android.content.Context
import android.os.Bundle
import android.view.View
import androidx.annotation.Keep
import androidx.fragment.app.Fragment
import dev.olog.core.dagger.injectable.InjectableComponent
import dev.olog.core.gateway.Repository
import dev.olog.detail.dagger.inject
import dev.olog.navigation.Params
import kotlinx.android.synthetic.main.activity_detail.*
import javax.inject.Inject

@Keep
class DetailFragment : Fragment(R.layout.fragment_detail),
    InjectableComponent {

    @Inject
    lateinit var repository: Repository

    override fun onAttach(context: Context) {
        inject((requireActivity() as DetailActivity).sharedComponent)
        super.onAttach(context)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val id = requireArguments().getLong(Params.LISTING_ID)

        listingId.text = "listing id $id"
        repo.text = repository.toString()
    }

}