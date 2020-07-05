package dev.olog.feature.detail.list

import android.os.Bundle
import android.view.View
import androidx.core.view.isVisible
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.paging.LoadState
import androidx.recyclerview.widget.GridLayoutManager
import dagger.hilt.android.AndroidEntryPoint
import dev.olog.feature.components.BaseFragment
import dev.olog.feature.components.adapter.FooterLoadingAdapter
import dev.olog.feature.detail.R
import dev.olog.feature.lazyFast
import kotlinx.android.synthetic.main.fragment_pokedex.*
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach

@AndroidEntryPoint
internal class PokedexFragment : BaseFragment(R.layout.fragment_pokedex) {

    private val viewModel: PokedexFragmentViewModel by viewModels()

    private val adapter by lazyFast {
        PokedexFragmentAdapter()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        list.setHasFixedSize(true)

        val footerAdapter = FooterLoadingAdapter()
        list.adapter = adapter.withLoadStateFooter(footerAdapter)
        list.layoutManager = GridLayoutManager(requireContext(), 2)

        viewModel.data
            .onEach {
                adapter.submitData(it)
            }.launchIn(viewLifecycleOwner.lifecycleScope)

        adapter.loadStateFlow
            .onEach { bindLoading(it.refresh) }
            .launchIn(viewLifecycleOwner.lifecycleScope)
    }

    private fun bindLoading(state: LoadState) {
        progress.isVisible = state is LoadState.Loading
    }

}