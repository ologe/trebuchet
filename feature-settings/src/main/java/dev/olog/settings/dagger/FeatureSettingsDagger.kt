package dev.olog.settings.dagger

import android.content.Context
import android.content.Intent
import dagger.*
import dagger.multibindings.IntoMap
import dev.olog.core.dagger.ApplicationContext
import dev.olog.core.dagger.FeatureScope
import dev.olog.core.dagger.injectable.Injectable
import dev.olog.core.dagger.injectable.InjectableKey
import dev.olog.navigation.screens.ActivityScreen
import dev.olog.navigation.dagger.ActivityScreenKey
import dev.olog.settings.SettingsActivity

class FeatureSettingsDagger {

    @Subcomponent
    @FeatureScope
    internal interface SettingsSubComponent : Injectable<SettingsActivity> {

        @Subcomponent.Factory
        interface Factory : Injectable.Factory {

            fun create(@BindsInstance instance: SettingsActivity): SettingsSubComponent

        }

    }

    @Module(subcomponents = [SettingsSubComponent::class])
    abstract class AppModule {

        @Binds
        @IntoMap
        @InjectableKey(SettingsActivity::class)
        internal abstract fun provideFactory(factory: SettingsSubComponent.Factory): Injectable.Factory

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