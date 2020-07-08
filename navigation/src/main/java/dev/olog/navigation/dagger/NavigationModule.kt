package dev.olog.navigation.dagger

import androidx.fragment.app.Fragment
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import dagger.multibindings.Multibinds
import dev.olog.navigation.Navigator
import dev.olog.navigation.impl.NavigatorImpl
import dev.olog.navigation.screens.FragmentScreen
import javax.inject.Singleton

@Module
@InstallIn(ApplicationComponent::class)
abstract class NavigationModule {

    @Binds
    @Singleton
    internal abstract fun provideNavigator(impl: NavigatorImpl): Navigator

    @Multibinds
    internal abstract fun fragments(): Map<FragmentScreen, @JvmSuppressWildcards Fragment>

}