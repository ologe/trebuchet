package dev.olog.data

import dagger.Binds
import dagger.Module
import dev.olog.domain.gateway.GithubGateway
import dev.olog.domain.gateway.UserGateway
import javax.inject.Singleton

@Module
abstract class DataModule {

    @Binds
    @Singleton
    internal abstract fun bindGithubRepo(impl: GithubRepository): GithubGateway

    @Binds
    @Singleton
    internal abstract fun bindUserRepo(impl: UserRepository): UserGateway

}