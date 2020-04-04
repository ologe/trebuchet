package dev.olog.navigation

import dagger.Binds
import dagger.Module
import dagger.multibindings.Multibinds
import dev.olog.navigation.dagger.FragmentsMap
import dev.olog.navigation.dagger.IntentsMap
import javax.inject.Singleton

@Module
abstract class NavigationModule {

    @Binds
    @Singleton
    internal abstract fun provideNavigator(impl: NavigatorImpl): Navigator

    @Multibinds
    internal abstract fun activities(): IntentsMap

    @Multibinds
    internal abstract fun fragments(): FragmentsMap

}