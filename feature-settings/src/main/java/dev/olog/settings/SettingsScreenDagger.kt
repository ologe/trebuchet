package dev.olog.settings

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

class SettingsScreenDagger {

    @Subcomponent
    @FeatureScope
    interface SettingsSubComponent : Injectable<SettingsActivity> {

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
        abstract fun provideFactory(factory: SettingsSubComponent.Factory): Injectable.Factory

        companion object {

            @IntoMap
            @Provides
            @ActivityScreenKey(ActivityScreen.SETTINGS)
            fun provideActivity(@ApplicationContext context: Context): Intent {
                return Intent(context, SettingsActivity::class.java)
            }

        }

    }


}