package dev.olog.detail.dagger

import android.content.Context
import android.content.Intent
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.Subcomponent
import dagger.multibindings.IntoMap
import dev.olog.core.dagger.ApplicationContext
import dev.olog.core.dagger.FeatureScope
import dev.olog.core.dagger.injectable.Injectable
import dev.olog.core.dagger.injectable.InjectableComponent
import dev.olog.core.dagger.injectable.InjectableKey
import dev.olog.detail.DetailActivity
import dev.olog.detail.DetailFragment
import dev.olog.navigation.dagger.ActivityScreenKey
import dev.olog.navigation.dagger.FragmentContainer
import dev.olog.navigation.dagger.FragmentScreenKey
import dev.olog.navigation.screens.ActivityScreen
import dev.olog.navigation.screens.FragmentScreen

// TODO find a way to share common dependencies inside this module, maybe doing a similar thing but
//  with a shared dagger.Component
class DetailScreenDagger {

    @Subcomponent
    @FeatureScope
    internal interface SharedComponent : Injectable<DetailActivity> {

        fun activityComponent(): DetailActivitySubComponent.Factory
        fun detailComponent(): DetailFragmentSubComponent.Factory

        @Subcomponent.Factory
        interface Factory : Injectable.Factory {

            fun create(): SharedComponent

        }

    }

    @Module(subcomponents = [SharedComponent::class])
    abstract class AppModule {

        @Binds
        @IntoMap
        @InjectableKey(DetailActivity::class)
        internal abstract fun provideActivityFactory(factory: SharedComponent.Factory): Injectable.Factory

        companion object {

            @IntoMap
            @Provides
            @ActivityScreenKey(ActivityScreen.DETAIL)
            fun provideActivity(@ApplicationContext context: Context): Intent {
                return Intent(context, DetailActivity::class.java)
            }

            @IntoMap
            @Provides
            @FragmentScreenKey(FragmentScreen.DETAIL)
            fun provideFragment(): FragmentContainer = DetailFragment::class.java

        }

    }


}