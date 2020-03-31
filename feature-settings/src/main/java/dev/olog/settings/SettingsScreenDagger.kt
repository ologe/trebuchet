package dev.olog.settings

import dagger.Binds
import dagger.BindsInstance
import dagger.Module
import dagger.Subcomponent
import dagger.multibindings.IntoMap
import dev.olog.core.dagger.FeatureScope
import dev.olog.core.dagger.injectable.Injectable
import dev.olog.core.dagger.injectable.InjectableKey

class SettingsScreenDagger {

    @Subcomponent
    @FeatureScope
    interface SettingsSubComponent : Injectable<SettingsActivity> {

        @Subcomponent.Factory
        interface Factory : Injectable.Factory<SettingsSubComponent> {

            fun create(@BindsInstance instance:SettingsActivity): SettingsSubComponent

        }

    }

    @Module
    abstract class AppModule {

        @Binds
        @IntoMap
        @InjectableKey(SettingsActivity::class)
        abstract fun provideFactory(factory: SettingsSubComponent.Factory): Injectable.Factory<*>

    }

    interface SettingsScreenGraph {
        fun settingsScreenFactory(): SettingsSubComponent.Factory
    }


}