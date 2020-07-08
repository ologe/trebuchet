package dev.olog.feature.items.dagger

import androidx.fragment.app.Fragment
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import dagger.multibindings.IntoMap
import dev.olog.feature.items.ItemsFragment
import dev.olog.navigation.dagger.FragmentScreenKey
import dev.olog.navigation.screens.FragmentScreen

@Module
@InstallIn(ApplicationComponent::class)
internal class FeatureItemsNavigationDagger {

    @IntoMap
    @Provides
    @FragmentScreenKey(FragmentScreen.ITEMS)
    internal fun provideFragment(): Fragment {
        return ItemsFragment()
    }


}