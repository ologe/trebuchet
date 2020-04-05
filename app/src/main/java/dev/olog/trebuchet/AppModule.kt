package dev.olog.trebuchet

import android.content.Context
import dagger.Binds
import dagger.Module
import dagger.Provides
import dev.olog.core.dagger.ApplicationContext
import dev.olog.core.gateway.Repository
import javax.inject.Singleton

@Module
abstract class AppModule {

    @Binds
    @ApplicationContext
    internal abstract fun provideContext(instance: App): Context

    companion object {
        @Provides
        @Singleton
        internal fun provideRepo(): Repository {
            return object : Repository {}
        }
    }

}