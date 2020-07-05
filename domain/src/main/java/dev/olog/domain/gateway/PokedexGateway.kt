package dev.olog.domain.gateway

import dev.olog.domain.entity.Pokemon

interface PokedexGateway {

    suspend fun getPokemonById(id: Int): Pokemon

}