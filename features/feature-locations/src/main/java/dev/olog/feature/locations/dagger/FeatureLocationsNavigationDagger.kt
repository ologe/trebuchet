package dev.olog.feature.locations.dagger

import androidx.fragment.app.Fragment
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import dagger.multibindings.IntoMap
import dev.olog.feature.locations.LocationsFragment
import dev.olog.navigation.dagger.FragmentScreenKey
import dev.olog.navigation.screens.FragmentScreen

@Module
@InstallIn(ApplicationComponent::class)
internal class FeatureLocationsNavigationDagger {

    @IntoMap
    @Provides
    @FragmentScreenKey(FragmentScreen.LOCATIONS)
    internal fun provideFragment(): Fragment {
        return LocationsFragment()
    }


}