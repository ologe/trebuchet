package dev.olog.domain.interactor

import dev.olog.domain.entity.GithubRepo
import dev.olog.domain.gateway.GithubGateway
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

class ObserveRepositoriesUseCase @Inject constructor(
    private val gateway: GithubGateway
) {

    operator fun invoke(): Flow<List<GithubRepo>> {
        return gateway.observeRepositories()
            .flowOn(Dispatchers.IO)
    }

}