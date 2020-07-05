package dev.olog.feature.detail.detail.about

import android.os.Bundle
import android.view.View
import dev.olog.domain.entity.Pokemon
import dev.olog.feature.android.argument
import dev.olog.feature.android.withArguments
import dev.olog.feature.components.BaseFragment
import dev.olog.feature.detail.R
import dev.olog.navigation.Params
import kotlinx.android.synthetic.main.fragment_pokedex_detail_about.*

internal class PokedexDetailAboutFragment : BaseFragment(R.layout.fragment_pokedex_detail_about) {

    companion object {

        fun newInstance(pokemon: Pokemon): PokedexDetailAboutFragment {
            return PokedexDetailAboutFragment()
                .withArguments(
                Params.POKEMON to pokemon
            )
        }

    }

    private val pokemon by argument<Pokemon>(Params.POKEMON)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        height.text = "${pokemon.height.toFloat() * 10} cm"
        weight.text = "${pokemon.weight.toFloat() / 10} kg"
    }

}