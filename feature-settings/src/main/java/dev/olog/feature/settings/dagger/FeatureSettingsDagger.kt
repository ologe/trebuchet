package dev.olog.feature.settings.dagger

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
import dev.olog.navigation.dagger.ActivityScreenKey
import dev.olog.navigation.screens.ActivityScreen
import dev.olog.feature.settings.SettingsActivity

class FeatureSettingsDagger {

    @Subcomponent
    @FeatureScope
    internal interface Graph : AndroidInjector<SettingsActivity> {

        @Subcomponent.Factory
        interface Factory : AndroidInjector.Factory<SettingsActivity>

    }

    @Module(subcomponents = [Graph::class])
    abstract class AppModule {

        @Binds
        @IntoMap
        @ClassKey(SettingsActivity::class)
        internal abstract fun provideFactory(factory: Graph.Factory): AndroidInjector.Factory<*>

        companion object {

            @IntoMap
            @Provides
            @ActivityScreenKey(ActivityScreen.SETTINGS)
            internal fun provideActivity(@ApplicationContext context: Context): Intent {
                return Intent(context, SettingsActivity::class.java)
            }

        }

    }


}