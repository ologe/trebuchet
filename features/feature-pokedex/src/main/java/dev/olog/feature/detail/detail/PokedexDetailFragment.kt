package dev.olog.feature.detail.detail

import android.graphics.Color
import android.os.Bundle
import android.view.View
import androidx.core.view.isInvisible
import androidx.core.view.isVisible
import com.bumptech.glide.Glide
import com.bumptech.glide.Priority
import com.google.android.material.tabs.TabLayoutMediator
import dev.olog.domain.entity.Pokemon
import dev.olog.feature.android.argument
import dev.olog.feature.components.BaseFragment
import dev.olog.feature.detail.R
import dev.olog.feature.lazyFast
import dev.olog.lib.image.loader.LoadPriority
import dev.olog.lib.image.loader.loadRequest
import dev.olog.navigation.Params
import kotlinx.android.synthetic.main.fragment_pokedex_detail.*

internal class PokedexDetailFragment : BaseFragment(R.layout.fragment_pokedex_detail) {

    private val pokemon by argument<Pokemon>(Params.POKEMON)

    private val tabLayoutMediator by lazyFast {
        TabLayoutMediator(tabLayout, pager, TabLayoutMediator.TabConfigurationStrategy { tab, position ->
            tab.text = when (position) {
                0 -> "About"
                1 -> "Base Stats"
                2 -> "Evolution"
                3 -> "Moves"
                else -> throw IllegalArgumentException("invalid position $position")
            }
        })
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        pager.adapter = PokedexDetailFragmentAdapter(pokemon, this)

        content.setBackgroundColor(Color.parseColor(pokemon.colorHex))

        loadRequest(pokemon.sprites.frontDefault)
            .priority(LoadPriority.HIGH)
            .into(sprite)

        back.setOnClickListener {
            requireActivity().onBackPressed()
        }

        name.text = pokemon.name
        type1.text = pokemon.type1.type
        type2.isInvisible = pokemon.type2 == null
        if (type2.isVisible) {
            type2.text = pokemon.type2!!.type
        }
        number.text = pokemon.number
        type.text = "Seed Pokemon" // missing data
    }

    override fun onResume() {
        super.onResume()
        tabLayoutMediator.attach()
    }

    override fun onPause() {
        super.onPause()
        tabLayoutMediator.detach()
    }

}