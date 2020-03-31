package dev.olog.trebuchet

import dagger.BindsInstance
import dagger.Component
import dagger.Module
import dagger.Provides
import dagger.multibindings.Multibinds
import dev.olog.core.dagger.injectable.Injectable
import dev.olog.core.gateway.Repository
import dev.olog.detail.DetailScreenDagger
import dev.olog.main.MainScreenDagger
import dev.olog.settings.SettingsScreenDagger
import javax.inject.Singleton

@Component(
    modules = [
        MainScreenDagger.AppModule::class,
        DetailScreenDagger.AppModule::class,
        SettingsScreenDagger.AppModule::class,

        AppModule::class
    ]
)
@Singleton
interface AppComponent :
    MainScreenDagger.MainScreenGraph,
    DetailScreenDagger.DetailScreenGraph,
    SettingsScreenDagger.SettingsScreenGraph {

    fun inject(app: App)

    @Component.Factory
    interface Factory {

        fun create(@BindsInstance app: App): AppComponent

    }

}

@Module
abstract class AppModule {

    @Multibinds
    abstract fun provideSubComponentBuilders(): Map<Class<*>, Injectable.Factory<*>>

    companion object {
        @Provides
        @Singleton
        fun provideRepo(): Repository {
            return object : Repository {}
        }
    }

}