package dev.olog.main.dagger

import android.content.Context
import android.content.Intent
import dagger.*
import dagger.multibindings.IntoMap
import dev.olog.core.dagger.ApplicationContext
import dev.olog.core.dagger.FeatureScope
import dev.olog.core.dagger.injectable.Injectable
import dev.olog.core.dagger.injectable.InjectableKey
import dev.olog.main.MainActivity
import dev.olog.navigation.screens.ActivityScreen
import dev.olog.navigation.dagger.ActivityScreenKey

// TODO this can be generated using any scripting language
class FeatureMainDagger {

    @Subcomponent(modules = [MainActivityModule::class])
    @FeatureScope
    internal interface MainSubComponent : Injectable<MainActivity> {

        @Subcomponent.Factory
        interface Factory : Injectable.Factory {

            fun create(@BindsInstance instance: MainActivity): MainSubComponent

        }

    }

    @Module(subcomponents = [MainSubComponent::class])
    abstract class AppModule {

        @Binds
        @IntoMap
        @InjectableKey(MainActivity::class)
        internal abstract fun provideFactory(factory: MainSubComponent.Factory): Injectable.Factory

        companion object {

            @Provides
            @IntoMap
            @ActivityScreenKey(ActivityScreen.MAIN)
            internal fun provideActivity(@ApplicationContext context: Context): Intent {
                return Intent(context, MainActivity::class.java)
            }

        }

    }

}