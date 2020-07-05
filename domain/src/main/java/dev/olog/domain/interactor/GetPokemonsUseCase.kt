package dev.olog.domain.interactor

import dev.olog.domain.entity.PokemonBrief
import dev.olog.domain.gateway.PokedexGateway
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class GetPokemonsUseCase @Inject constructor(
    private val gateway: PokedexGateway
) {

    // TODO inject dispatchers
    suspend operator fun invoke(): List<PokemonBrief> = withContext(Dispatchers.IO) {
        gateway.getPokemons()
    }

}