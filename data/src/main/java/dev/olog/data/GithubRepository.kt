package dev.olog.data

import dev.olog.domain.entity.GithubRepo
import dev.olog.domain.entity.User
import dev.olog.domain.gateway.GithubGateway
import dev.olog.domain.gateway.UserGateway
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.map
import org.eclipse.egit.github.core.client.GitHubClient
import org.eclipse.egit.github.core.service.RepositoryService
import javax.inject.Inject

internal class GithubRepository @Inject constructor(
    userGateway: UserGateway
) : GithubGateway {

    private val client = userGateway.observe()
        .map { buildClient(it) }

    private val repositoryService = client.map { RepositoryService(it) }

    private fun buildClient(user: User): GitHubClient {
        return GitHubClient().apply {
            setOAuth2Token("remove this")
        }
    }

    override fun observeRepositories(): Flow<List<GithubRepo>> {
        return repositoryService.map {
            it.repositories.map { it.toDomain() }
        }.catch { ex ->
            ex.printStackTrace()
            emptyList<GithubRepo>()
        }
    }
}