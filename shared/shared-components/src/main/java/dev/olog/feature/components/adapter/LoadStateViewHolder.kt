package dev.olog.feature.components.adapter

import android.view.View
import androidx.core.view.isVisible
import androidx.paging.LoadState
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.load_state_item.view.*

class LoadStateViewHolder(
    view: View
) : RecyclerView.ViewHolder(view) {

    fun bind(loadState: LoadState) {
        itemView.progress.isVisible = loadState is LoadState.Loading
    }
}