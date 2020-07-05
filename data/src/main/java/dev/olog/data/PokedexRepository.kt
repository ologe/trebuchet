package dev.olog.data

import dev.olog.domain.entity.Pokemon
import dev.olog.domain.entity.PokemonBrief
import dev.olog.domain.gateway.PokedexGateway
import me.sargunvohra.lib.pokekotlin.client.PokeApiClient
import javax.inject.Inject

internal class PokedexRepository @Inject constructor(

) : PokedexGateway {

    private val api = PokeApiClient()

    override fun getPokemons(): List<PokemonBrief> {
        return api.getPokemonList(0, 50).results.map { it.toEntity() }
    }

    override fun getPokemonById(id: Int): Pokemon {
        return api.getPokemon(id).toEntity()
    }
}