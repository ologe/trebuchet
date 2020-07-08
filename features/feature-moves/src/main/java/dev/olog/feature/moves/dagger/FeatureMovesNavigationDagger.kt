package dev.olog.feature.moves.dagger

import androidx.fragment.app.Fragment
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import dagger.multibindings.IntoMap
import dev.olog.feature.moves.MovesFragment
import dev.olog.navigation.dagger.FragmentScreenKey
import dev.olog.navigation.screens.FragmentScreen

@Module
@InstallIn(ApplicationComponent::class)
internal class FeatureMovesNavigationDagger {

    @IntoMap
    @Provides
    @FragmentScreenKey(FragmentScreen.MOVES)
    internal fun provideFragment(): Fragment {
        return MovesFragment()
    }


}