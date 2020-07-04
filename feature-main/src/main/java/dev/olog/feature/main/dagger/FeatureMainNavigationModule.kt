package dev.olog.feature.main.dagger

import androidx.fragment.app.Fragment
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import dagger.multibindings.IntoMap
import dev.olog.feature.main.MainFragment
import dev.olog.navigation.dagger.FragmentScreenKey
import dev.olog.navigation.screens.FragmentScreen

@Module
@InstallIn(ApplicationComponent::class)
internal class FeatureMainNavigationModule {

    @Provides
    @IntoMap
    @FragmentScreenKey(FragmentScreen.MAIN)
    internal fun provideFragment(): Fragment {
        return MainFragment()
    }

}