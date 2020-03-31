package dev.olog.main

import dagger.Binds
import dagger.Module
import dagger.Subcomponent
import dagger.multibindings.IntoMap
import dev.olog.core.dagger.FeatureScope
import dev.olog.core.dagger.injectable.Injectable
import dev.olog.core.dagger.injectable.InjectableKey

class MainScreenDagger {

    @Subcomponent
    @FeatureScope
    interface MainSubComponent :
        Injectable<MainActivity> {

        @Subcomponent.Builder
        interface Builder : Injectable.Builder<MainSubComponent>

    }

    @Module
    abstract class AppModule {

        // adds builder exposed by `MainScreenGraph` to a multibinding map
        @Binds
        @IntoMap
        @InjectableKey(MainActivity::class)
        abstract fun provideBuilder(builder: MainSubComponent.Builder): Injectable.Builder<*>

    }

    // exposes `MainSubComponent.Builder` from `AppComponent`
    interface MainScreenGraph {
        fun mainScreenBuilder(): MainSubComponent.Builder
    }

}