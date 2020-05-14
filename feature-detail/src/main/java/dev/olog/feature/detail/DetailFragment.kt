package dev.olog.feature.detail

import android.os.Bundle
import android.view.View
import dagger.android.support.DaggerFragment
import dev.olog.domain.entity.GithubRepo
import dev.olog.navigation.Params
import kotlinx.android.synthetic.main.fragment_detail.*
import javax.inject.Inject

internal class DetailFragment : DaggerFragment(R.layout.fragment_detail) {

    @Inject
    lateinit var controller: DetailFragmentController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        postponeEnterTransition()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        view.transitionName = requireArguments().getString(Params.TRANSITION_NAME)

        val repo = requireArguments().getParcelable<GithubRepo>(Params.REPO)!!

        text.text = repo.name
        startPostponedEnterTransition()
    }

}