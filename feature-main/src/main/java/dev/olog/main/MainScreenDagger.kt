package dev.olog.main

import android.content.Context
import android.content.Intent
import dagger.*
import dagger.multibindings.IntoMap
import dev.olog.core.dagger.ApplicationContext
import dev.olog.core.dagger.FeatureScope
import dev.olog.core.dagger.injectable.Injectable
import dev.olog.core.dagger.injectable.InjectableKey
import dev.olog.navigation.ActivityScreen
import dev.olog.navigation.ActivityScreenKey

// TODO this can be generated using ktscript
class MainScreenDagger {

    @Subcomponent
    @FeatureScope
    interface MainSubComponent : Injectable<MainActivity> {

        @Subcomponent.Factory
        interface Factory : Injectable.Factory {

            fun create(@BindsInstance instance: MainActivity): MainSubComponent

        }

    }

    @Module(subcomponents = [MainSubComponent::class])
    abstract class AppModule {

        // adds factory exposed by `MainScreenGraph` to a multibinding map
        @Binds
        @IntoMap
        @InjectableKey(MainActivity::class)
        abstract fun provideFactory(factory: MainSubComponent.Factory): Injectable.Factory

        companion object {

            @Provides
            @IntoMap
            @ActivityScreenKey(ActivityScreen.MAIN)
            fun provideActivity(@ApplicationContext context: Context): Intent {
                return Intent(context, MainActivity::class.java)
            }

        }

    }

}