package dev.olog.feature.detail.detail

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import dev.olog.domain.entity.Pokemon
import dev.olog.feature.detail.detail.about.PokedexDetailAboutFragment
import dev.olog.feature.detail.detail.evolution.PokedexDetailEvolutionFragment
import dev.olog.feature.detail.detail.moves.PokedexDetailMovesFragment
import dev.olog.feature.detail.detail.stats.PokedexDetailStatsFragment

internal class PokedexDetailFragmentAdapter(
    private val pokemon: Pokemon,
    fragment: Fragment
) : FragmentStateAdapter(fragment) {

    override fun getItemCount(): Int = 4

    override fun createFragment(position: Int): Fragment = when (position) {
        0 -> PokedexDetailAboutFragment.newInstance(pokemon)
        1 -> PokedexDetailStatsFragment.newInstance(pokemon)
        2 -> PokedexDetailEvolutionFragment.newInstance(pokemon)
        3 -> PokedexDetailMovesFragment.newInstance(pokemon)
        else -> throw IllegalArgumentException("invalid position $position")
    }
}