package dev.olog.feature.detail.detail.moves

import dev.olog.domain.entity.Pokemon
import dev.olog.feature.android.withArguments
import dev.olog.feature.components.BaseFragment
import dev.olog.feature.detail.R
import dev.olog.navigation.Params

internal class PokedexDetailMovesFragment : BaseFragment(R.layout.fragment_pokedex_detail_moves) {

    companion object {

        fun newInstance(pokemon: Pokemon): PokedexDetailMovesFragment {
            return PokedexDetailMovesFragment()
                .withArguments(
                Params.POKEMON to pokemon
            )
        }

    }

}