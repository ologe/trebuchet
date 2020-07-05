package dev.olog.feature.detail.dagger

import androidx.fragment.app.Fragment
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import dagger.multibindings.IntoMap
import dev.olog.feature.detail.list.PokedexFragment
import dev.olog.navigation.dagger.FragmentScreenKey
import dev.olog.navigation.screens.FragmentScreen

@Module
@InstallIn(ApplicationComponent::class)
internal class FeaturePokedexNavigationDagger {

    @IntoMap
    @Provides
    @FragmentScreenKey(FragmentScreen.POKEDEX)
    internal fun provideFragment(): Fragment {
        return PokedexFragment()
    }


}