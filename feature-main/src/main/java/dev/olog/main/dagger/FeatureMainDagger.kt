package dev.olog.main.dagger

import android.content.Context
import android.content.Intent
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.Subcomponent
import dagger.android.AndroidInjector
import dagger.multibindings.ClassKey
import dagger.multibindings.IntoMap
import dev.olog.core.dagger.ApplicationContext
import dev.olog.core.dagger.FeatureScope
import dev.olog.main.MainActivity
import dev.olog.navigation.dagger.ActivityScreenKey
import dev.olog.navigation.screens.ActivityScreen

// TODO this can be generated using any scripting language
class FeatureMainDagger {

    @Subcomponent(modules = [MainActivityModule::class])
    @FeatureScope
    internal interface MainSubComponent : AndroidInjector<MainActivity> {

        @Subcomponent.Factory
        interface Factory : AndroidInjector.Factory<MainActivity>

    }

    @Module(subcomponents = [MainSubComponent::class])
    abstract class AppModule {

        @Binds
        @IntoMap
        @ClassKey(MainActivity::class)
        internal abstract fun provideFactory(factory: MainSubComponent.Factory): AndroidInjector.Factory<*>

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