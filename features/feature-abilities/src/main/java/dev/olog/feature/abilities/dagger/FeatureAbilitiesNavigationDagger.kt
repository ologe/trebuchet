package dev.olog.feature.abilities.dagger

import androidx.fragment.app.Fragment
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import dagger.multibindings.IntoMap
import dev.olog.feature.abilities.AbilitiesFragment
import dev.olog.navigation.dagger.FragmentScreenKey
import dev.olog.navigation.screens.FragmentScreen

@Module
@InstallIn(ApplicationComponent::class)
internal class FeatureAbilitiesNavigationDagger {

    @IntoMap
    @Provides
    @FragmentScreenKey(FragmentScreen.ABILITIES)
    internal fun provideFragment(): Fragment {
        return AbilitiesFragment()
    }


}