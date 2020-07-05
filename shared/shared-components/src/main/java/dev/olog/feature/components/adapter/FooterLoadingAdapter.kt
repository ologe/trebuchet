package dev.olog.feature.components.adapter

import android.view.ViewGroup
import androidx.paging.LoadState
import androidx.paging.LoadStateAdapter
import dev.olog.feature.android.inflate
import dev.olog.feature.components.R

class FooterLoadingAdapter(

) : LoadStateAdapter<LoadStateViewHolder>() {

    override fun onCreateViewHolder(
        parent: ViewGroup,
        loadState: LoadState
    ): LoadStateViewHolder {
        val view = parent.inflate(R.layout.load_state_item)
        return LoadStateViewHolder(view)
    }

    override fun onBindViewHolder(
        holder: LoadStateViewHolder,
        loadState: LoadState
    ) = holder.bind(loadState)

    override fun getStateViewType(loadState: LoadState): Int = when (loadState) {
        is LoadState.Loading -> R.layout.load_state_item
        is LoadState.NotLoading -> 0
        is LoadState.Error -> 0
    }

}