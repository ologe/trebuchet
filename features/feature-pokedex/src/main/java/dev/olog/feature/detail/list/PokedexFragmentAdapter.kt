package dev.olog.feature.detail.list

import android.annotation.SuppressLint
import android.graphics.Color
import android.view.ViewGroup
import androidx.core.view.isInvisible
import androidx.core.view.isVisible
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.Priority
import dev.olog.domain.entity.Pokemon
import dev.olog.feature.android.inflate
import dev.olog.feature.components.adapter.SimpleViewHolder
import dev.olog.feature.detail.R
import kotlinx.android.synthetic.main.item_pokedex.view.*

internal class PokedexFragmentAdapter(

) : PagingDataAdapter<Pokemon, SimpleViewHolder>(PokemonDiff) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SimpleViewHolder {
        val view = parent.inflate(R.layout.item_pokedex)
        return SimpleViewHolder(view)
    }

    override fun onBindViewHolder(holder: SimpleViewHolder, position: Int) {
        val item = getItem(position)
        if (item != null) {
            holder.bindItem(item)
        }
    }

    @SuppressLint("SetTextI18n")
    private fun RecyclerView.ViewHolder.bindItem(
        pokemon: Pokemon
    ) = with(itemView) {
        content.setCardBackgroundColor(Color.parseColor(pokemon.colorHex))

        name.text = pokemon.name
        type1.text = pokemon.type1.type
        type2.isInvisible = pokemon.type2 == null
        if (type2.isVisible) {
            type2.text = pokemon.type2!!.type
        }
        number.text = "#${pokemon.order.toString().padStart(3, '0')}"

        // TODO move load lib loader
        Glide.with(context)
            .load(pokemon.sprites.frontDefault)
            .priority(Priority.IMMEDIATE)
            .centerCrop()
            .into(sprite)
    }

}

private object PokemonDiff : DiffUtil.ItemCallback<Pokemon>() {

    override fun areItemsTheSame(oldItem: Pokemon, newItem: Pokemon): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: Pokemon, newItem: Pokemon): Boolean {
        return oldItem == newItem
    }
}