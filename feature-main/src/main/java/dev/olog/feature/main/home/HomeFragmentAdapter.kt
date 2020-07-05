package dev.olog.feature.main.home

import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import dev.olog.feature.main.R
import dev.olog.feature.presentation.base.SimpleViewHolder
import dev.olog.shared.android.inflate

internal class HomeFragmentAdapter(

) : ListAdapter<HomeFragmentModel, SimpleViewHolder>(HomeFragmentModelDiff) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SimpleViewHolder {
        val view = parent.inflate(viewType)
        return SimpleViewHolder(view)
    }

    override fun onBindViewHolder(holder: SimpleViewHolder, position: Int) {

    }

    override fun getItemViewType(position: Int) = when (getItem(position)) {
        is HomeFragmentModel.Search -> R.layout.item_search
    }
}

private object HomeFragmentModelDiff : DiffUtil.ItemCallback<HomeFragmentModel>() {

    override fun areItemsTheSame(oldItem: HomeFragmentModel, newItem: HomeFragmentModel): Boolean {
        return oldItem == newItem
    }

    override fun areContentsTheSame(
        oldItem: HomeFragmentModel,
        newItem: HomeFragmentModel
    ): Boolean {
        return oldItem == newItem
    }
}