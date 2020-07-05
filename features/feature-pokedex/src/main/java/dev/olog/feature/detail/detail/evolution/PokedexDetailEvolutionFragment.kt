package dev.olog.feature.detail.detail.evolution

import dev.olog.domain.entity.Pokemon
import dev.olog.feature.android.withArguments
import dev.olog.feature.components.BaseFragment
import dev.olog.feature.detail.R
import dev.olog.navigation.Params

internal class PokedexDetailEvolutionFragment(

) : BaseFragment(R.layout.fragment_pokedex_detail_evolution) {

    companion object {

        fun newInstance(pokemon: Pokemon): PokedexDetailEvolutionFragment {
            return PokedexDetailEvolutionFragment()
                .withArguments(
                Params.POKEMON to pokemon
            )
        }

    }

}