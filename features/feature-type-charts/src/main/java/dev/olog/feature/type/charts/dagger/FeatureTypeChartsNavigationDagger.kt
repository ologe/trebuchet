package dev.olog.feature.type.charts.dagger

import androidx.fragment.app.Fragment
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import dagger.multibindings.IntoMap
import dev.olog.feature.type.charts.TypeChartsFragment
import dev.olog.navigation.dagger.FragmentScreenKey
import dev.olog.navigation.screens.FragmentScreen

@Module
@InstallIn(ApplicationComponent::class)
internal class FeatureTypeChartsNavigationDagger {

    @IntoMap
    @Provides
    @FragmentScreenKey(FragmentScreen.TYPE_CHARTS)
    internal fun provideFragment(): Fragment {
        return TypeChartsFragment()
    }


}