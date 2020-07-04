package dev.olog.feature.detail

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import dev.olog.domain.entity.GithubRepo
import dev.olog.navigation.Params
import kotlinx.android.synthetic.main.fragment_detail.*

internal class DetailFragment : Fragment(R.layout.fragment_detail) {

    private val viewModel: DetailFragmentViewModel by viewModels()

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