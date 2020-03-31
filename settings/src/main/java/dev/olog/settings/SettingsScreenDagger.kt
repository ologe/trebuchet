package dev.olog.settings

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

        companion object {
            @Provides
            @IntoSet
            fun provideTrebuchetKeys(): TrebuchetKey {
                return object : TrebuchetKey("settings") {}
            }
        }

    }

    interface SettingsScreenGraph {
        fun settingsScreenBuilder(): SettingsSubComponent.Builder
    }


}