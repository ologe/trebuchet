package dev.olog.domain.gateway

import dev.olog.domain.entity.Pokemon
import dev.olog.domain.entity.PokemonBrief

interface PokedexGateway {

    fun getPokemons(): List<PokemonBrief>

    fun getPokemonById(id: Int): Pokemon

}