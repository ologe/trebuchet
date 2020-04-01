package dev.olog.navigation

import dagger.Binds
import dagger.Module
import dagger.multibindings.Multibinds
import javax.inject.Singleton

@Module
abstract class NavigationModule {

    @Binds
    @Singleton
    internal abstract fun provideNavigator(impl: NavigatorImpl): Navigator

    @Multibinds
    abstract fun activities(): IntentsMap

    @Multibinds
    abstract fun fragments(): FragmentsMap

}