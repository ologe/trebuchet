package dev.olog.trebuchet

import dagger.BindsInstance
import dagger.Component
import dagger.Module
import dagger.Provides
import dagger.multibindings.Multibinds
import dev.olog.core.dagger.injectable.Injectable
import dev.olog.core.dagger.injectable.InjectableComponent
import dev.olog.core.gateway.Repository
import dev.olog.flavor.FlavorModule
import dev.olog.navigation.NavigationModule
import javax.inject.Singleton

@Component(
    modules = [
        AppModule::class,
        FlavorModule::class,
        NavigationModule::class
    ]
)
@Singleton
interface AppComponent {

    fun inject(app: App)

    @Component.Factory
    interface Factory {

        fun create(@BindsInstance app: App): AppComponent

    }

}

@Module
abstract class AppModule {

    @Multibinds
    abstract fun provideSubComponentBuilders(): Map<Class<out InjectableComponent>, Injectable.Factory<*>>

    companion object {
        @Provides
        @Singleton
        fun provideRepo(): Repository {
            return object : Repository {}
        }
    }

}