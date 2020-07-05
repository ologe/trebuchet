package dev.olog.data.repository

import dev.olog.data.dao.PokemonDao
import dev.olog.data.toDomain
import dev.olog.data.toEntity
import dev.olog.domain.entity.Pokemon
import dev.olog.domain.gateway.PokedexGateway
import me.sargunvohra.lib.pokekotlin.client.PokeApiClient
import javax.inject.Inject

internal class PokedexRepository @Inject constructor(
    private val dao: PokemonDao
) : PokedexGateway {

    private val api = PokeApiClient()

    override suspend fun getPokemonById(id: Int): Pokemon {
        val cached = dao.getById(id)
        if (cached != null) {
            return cached.toDomain()
        }
        val result = api.getPokemon(id).toDomain()
        dao.insert(result.toEntity())
        return result
    }
}