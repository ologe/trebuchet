package dev.olog.main

import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.Subcomponent
import dagger.multibindings.IntoMap
import dagger.multibindings.IntoSet
import dev.olog.core.dagger.FeatureScope
import dev.olog.core.dagger.injectable.Injectable
import dev.olog.core.dagger.injectable.InjectableKey
import dev.olog.core.navigation.TrebuchetKey

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

        companion object {
            @Provides
            @IntoSet
            fun provideTrebuchetKeys(): TrebuchetKey {
                return object : TrebuchetKey("main") {}
            }
        }

    }

    // exposes `MainSubComponent.Builder` from `AppComponent`
    interface MainScreenGraph {
        fun mainScreenBuilder(): MainSubComponent.Builder
    }

}