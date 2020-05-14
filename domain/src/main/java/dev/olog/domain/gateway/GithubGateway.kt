package dev.olog.domain.gateway

import dev.olog.domain.entity.GithubRepo
import kotlinx.coroutines.flow.Flow

interface GithubGateway {

    fun observeRepositories(): Flow<List<GithubRepo>>

}