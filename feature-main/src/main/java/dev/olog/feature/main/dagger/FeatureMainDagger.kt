package dev.olog.feature.main.dagger

import androidx.fragment.app.Fragment
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.Subcomponent
import dagger.android.AndroidInjector
import dagger.multibindings.ClassKey
import dagger.multibindings.IntoMap
import dev.olog.core.dagger.ActivityScope
import dev.olog.feature.main.MainActivity
import dev.olog.feature.main.MainFragment
import dev.olog.navigation.dagger.FragmentScreenKey
import dev.olog.navigation.screens.FragmentScreen

// TODO this can be generated using any scripting language
class FeatureMainDagger {

    @Subcomponent(modules = [MainActivityModule::class])
    @ActivityScope
    internal interface Graph : AndroidInjector<MainActivity> {

        @Subcomponent.Factory
        interface Factory : AndroidInjector.Factory<MainActivity>

    }

    @Module(subcomponents = [Graph::class])
    abstract class AppModule {

        @Binds
        @IntoMap
        @ClassKey(MainActivity::class)
        internal abstract fun provideFactory(factory: Graph.Factory): AndroidInjector.Factory<*>

        companion object {

            @Provides
            @IntoMap
            @FragmentScreenKey(FragmentScreen.MAIN)
            internal fun provideFragment(): Fragment {
                return MainFragment()
            }

        }

    }

}