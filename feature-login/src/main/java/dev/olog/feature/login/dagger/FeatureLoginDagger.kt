package dev.olog.feature.login.dagger

import androidx.fragment.app.Fragment
import dagger.Module
import dagger.Provides
import dagger.android.ContributesAndroidInjector
import dagger.multibindings.IntoMap
import dev.olog.core.dagger.FeatureScope
import dev.olog.feature.login.LoginFragment
import dev.olog.navigation.dagger.FragmentScreenKey
import dev.olog.navigation.screens.FragmentScreen

class FeatureLoginDagger {

    @Module
    abstract class AppModule {

        @ContributesAndroidInjector
        @FeatureScope
        internal abstract fun provideLoginFragment(): LoginFragment

        companion object {

            @Provides
            @IntoMap
            @FragmentScreenKey(FragmentScreen.LOGIN)
            internal fun provideLoginFragment(): Fragment {
                return LoginFragment()
            }

        }

    }

}