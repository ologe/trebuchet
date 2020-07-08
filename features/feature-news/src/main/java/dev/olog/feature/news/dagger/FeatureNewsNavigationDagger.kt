package dev.olog.feature.news.dagger

import androidx.fragment.app.Fragment
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import dagger.multibindings.IntoMap
import dev.olog.feature.news.NewsFragment
import dev.olog.navigation.dagger.FragmentScreenKey
import dev.olog.navigation.screens.FragmentScreen

@Module
@InstallIn(ApplicationComponent::class)
internal class FeatureNewsNavigationDagger {

    @IntoMap
    @Provides
    @FragmentScreenKey(FragmentScreen.NEWS)
    internal fun provideFragment(): Fragment {
        return NewsFragment()
    }


}