package dev.olog.navigation

import dev.olog.domain.entity.Pokemon

interface Navigator {

    fun toPokedex()
    fun toPokedexDetail(pokemon: Pokemon)

    fun toMoves()

    fun toAbilities()

    fun toItems()

    fun toLocations()

    fun toTypeCharts()

    fun toNews()

    fun toSearch()

}