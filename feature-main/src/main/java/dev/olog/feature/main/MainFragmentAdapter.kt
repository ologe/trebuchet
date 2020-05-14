package dev.olog.feature.main

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import dev.olog.domain.entity.GithubRepo
import kotlinx.android.synthetic.main.item_repo.view.*

internal class MainFragmentAdapter(
    private val navigateToDetail: (GithubRepo, View) -> Unit
) : ListAdapter<GithubRepo, RecyclerView.ViewHolder>(DiffUtil) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_repo, parent, false)

        val vh = object : RecyclerView.ViewHolder(view) {}

        view.setOnClickListener {
            val item = getItem(vh.adapterPosition)
            navigateToDetail(item, it)
        }
        return vh
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val item = getItem(position)

        holder.itemView.apply {
            transitionName = "$item"

            name.text = item.name
            owner.text = item.description
            stars.text = item.forks.toString()
        }
    }
}

private object DiffUtil : DiffUtil.ItemCallback<GithubRepo>() {

    override fun areItemsTheSame(oldItem: GithubRepo, newItem: GithubRepo): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: GithubRepo, newItem: GithubRepo): Boolean {
        return oldItem == newItem
    }
}