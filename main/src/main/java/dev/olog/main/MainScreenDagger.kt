package dev.olog.main

import dagger.Binds
import dagger.BindsInstance
import dagger.Module
import dagger.Subcomponent
import dagger.multibindings.IntoMap
import dev.olog.core.dagger.FeatureScope
import dev.olog.core.dagger.injectable.Injectable
import dev.olog.core.dagger.injectable.InjectableKey

// TODO this can be generated using ktscript
class MainScreenDagger {

    @Subcomponent
    @FeatureScope
    interface MainSubComponent : Injectable<MainActivity> {

        @Subcomponent.Factory
        interface Factory : Injectable.Factory<MainSubComponent> {

            fun create(@BindsInstance instance: MainActivity): MainSubComponent

        }

    }

    @Module
    abstract class AppModule {

        // adds factory exposed by `MainScreenGraph` to a multibinding map
        @Binds
        @IntoMap
        @InjectableKey(MainActivity::class)
        abstract fun provideFactory(factory: MainSubComponent.Factory): Injectable.Factory<*>

    }

    // TODO exposes `MainSubComponent.Factory` from `AppComponent`, this allows lazy subcompoments
    interface MainScreenGraph {
        fun mainScreenFactory(): MainSubComponent.Factory
    }

}