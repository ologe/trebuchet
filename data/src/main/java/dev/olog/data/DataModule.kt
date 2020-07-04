package dev.olog.data

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import dev.olog.domain.gateway.GithubGateway
import dev.olog.domain.gateway.UserGateway
import javax.inject.Singleton

@Module
@InstallIn(ApplicationComponent::class)
abstract class DataModule {

    @Binds
    @Singleton
    internal abstract fun bindGithubRepo(impl: GithubRepository): GithubGateway

    @Binds
    @Singleton
    internal abstract fun bindUserRepo(impl: UserRepository): UserGateway

}