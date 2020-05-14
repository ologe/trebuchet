package dev.olog.domain.interactor

import dev.olog.domain.entity.GithubRepo
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class ObserveRepositoryByIdUseCase @Inject constructor(
    private val observeRepositoriesUseCase: ObserveRepositoriesUseCase
) {

    operator fun invoke(id: Long): Flow<GithubRepo> {
        return observeRepositoriesUseCase()
            .map { it.first { it.id == id } }
            .flowOn(Dispatchers.IO)
    }

}