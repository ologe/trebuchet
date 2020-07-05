package dev.olog.feature.main.home

import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import dev.olog.feature.main.R
import dev.olog.feature.components.adapter.SimpleViewHolder
import dev.olog.feature.android.inflate
import kotlinx.android.synthetic.main.item_search.view.*

internal class HomeFragmentAdapter(
    private val viewModel: HomeFragmentViewModel
) : ListAdapter<HomeFragmentModel, SimpleViewHolder>(HomeFragmentModelDiff) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SimpleViewHolder {
        val view = parent.inflate(viewType)
        val vh = SimpleViewHolder(view)
        initializeListeners(vh, viewType)
        return vh
    }

    private fun initializeListeners(holder: SimpleViewHolder, viewType: Int) {
        if (viewType == R.layout.item_search) {
            holder.itemView.pokedex.setOnClickListener {
                viewModel.navigateToPokedex()
            }
            holder.itemView.moves.setOnClickListener {
                viewModel.navigateToMoves()
            }
            holder.itemView.abilities.setOnClickListener {
                viewModel.navigateToAbilities()
            }
            holder.itemView.items.setOnClickListener {
                viewModel.navigateToItems()
            }
            holder.itemView.locations.setOnClickListener {
                viewModel.navigateToLocations()
            }
            holder.itemView.typeCharts.setOnClickListener {
                viewModel.navigateToTypeCharts()
            }
        }
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