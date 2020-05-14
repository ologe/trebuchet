package dev.olog.data

import dev.olog.domain.entity.GithubRepo
import dev.olog.domain.entity.GithubUser
import org.eclipse.egit.github.core.Repository
import org.eclipse.egit.github.core.User

internal fun Repository.toDomain(): GithubRepo {
    return GithubRepo(
        fork = this.isFork,
        createdAt = this.createdAt,
        description = this.description,
        forks = this.forks,
        hasDownloads = this.isHasDownloads,
        hasIssues = this.isHasIssues,
        hasWiki = this.isHasWiki,
        homepage = this.homepage,
        id = this.id,
        isPrivate = this.isPrivate,
        language = this.language,
        name = this.name,
        openIssues = this.openIssues,
        owner = this.owner.toDomain(),
        pushedAt = this.pushedAt,
        size = this.size,
        updatedAt = this.updatedAt,
        watchers = this.watchers
    )
}

internal fun User.toDomain(): GithubUser {
    return GithubUser(
        id = this.id,
        name = this.name,
        avatarUrl = this.avatarUrl,
        email = this.email
    )
}