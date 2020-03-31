package dev.olog.settings

import dagger.Binds
import dagger.Module
import dagger.Subcomponent
import dagger.multibindings.IntoMap
import dev.olog.core.dagger.FeatureScope
import dev.olog.core.dagger.injectable.Injectable
import dev.olog.core.dagger.injectable.InjectableKey

class SettingsScreenDagger {

    @Subcomponent
    @FeatureScope
    interface SettingsSubComponent :
        Injectable<SettingsActivity> {

        @Subcomponent.Builder
        interface Builder : Injectable.Builder<SettingsSubComponent>

    }

    @Module
    abstract class AppModule {

        @Binds
        @IntoMap
        @InjectableKey(SettingsActivity::class)
        abstract fun provideBuilder(builder: SettingsSubComponent.Builder): Injectable.Builder<*>

    }

    interface SettingsScreenGraph {
        fun settingsScreenBuilder(): SettingsSubComponent.Builder
    }


}