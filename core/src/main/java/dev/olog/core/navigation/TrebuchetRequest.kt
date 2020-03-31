package dev.olog.core.navigation

import dagger.Module
import dagger.multibindings.Multibinds
import dev.olog.core.navigation.TrebuchetKey

@Module
abstract class BaseAppModule {

    @Multibinds
    abstract fun provideTrebuchetKeys(): Set<TrebuchetKey>

}