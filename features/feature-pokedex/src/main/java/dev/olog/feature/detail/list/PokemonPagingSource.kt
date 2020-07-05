package dev.olog.feature.detail.list

import androidx.paging.PagingSource
import dev.olog.domain.entity.Pokemon
import dev.olog.domain.interactor.GetPokemonByIdUseCase
import kotlinx.coroutines.async
import kotlinx.coroutines.awaitAll
import kotlinx.coroutines.coroutineScope
import javax.inject.Inject

internal class PokemonPagingSource @Inject constructor(
    private val getPokemonByIdUseCase: GetPokemonByIdUseCase
) : PagingSource<Int, Pokemon>() {

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Pokemon> {
        val nextPageNumber = params.key ?: 0

        val data = coroutineScope {
            (1..params.loadSize)
                .map { nextPageNumber * params.loadSize + it }
                .map { async { getPokemonByIdUseCase(it) } }
                .awaitAll()
        }

        return LoadResult.Page(
            data = data,
            prevKey = null,
            nextKey = nextPageNumber + 1
        )
    }
}