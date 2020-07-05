package dev.olog.feature.detail.detail.stats

import dev.olog.domain.entity.Pokemon
import dev.olog.feature.android.withArguments
import dev.olog.feature.components.BaseFragment
import dev.olog.feature.detail.R
import dev.olog.navigation.Params

internal class PokedexDetailStatsFragment : BaseFragment(R.layout.fragment_pokedex_detail_stats) {

    companion object {

        fun newInstance(pokemon: Pokemon): PokedexDetailStatsFragment {
            return PokedexDetailStatsFragment()
                .withArguments(
                Params.POKEMON to pokemon
            )
        }

    }

}