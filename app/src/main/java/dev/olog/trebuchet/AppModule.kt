package dev.olog.trebuchet

import android.content.Context
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.multibindings.Multibinds
import dev.olog.core.dagger.ApplicationContext
import dev.olog.core.dagger.injectable.InjectableComponentsMap
import dev.olog.core.gateway.Repository
import javax.inject.Singleton

@Module
abstract class AppModule {

    @Binds
    @ApplicationContext
    abstract fun provideContext(app: App): Context

    @Multibinds
    abstract fun provideSubComponentBuilders(): InjectableComponentsMap

    companion object {
        @Provides
        @Singleton
        fun provideRepo(): Repository {
            return object : Repository {}
        }
    }

}