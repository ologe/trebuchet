package dev.olog.domain.interactor

import dev.olog.domain.entity.Pokemon
import dev.olog.domain.gateway.PokedexGateway
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class GetPokemonByIdUseCase @Inject constructor(
    private val gateway: PokedexGateway
) {

    // TODO inject dispatchers
    suspend operator fun invoke(id: Int): Pokemon = withContext(Dispatchers.IO) {
        gateway.getPokemonById(id)
    }

}