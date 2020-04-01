package dev.olog.detail

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
import dev.olog.core.dagger.injectable.InjectableKey
import dev.olog.navigation.*

class DetailScreenDagger {

    @Subcomponent
    @FeatureScope
    interface DetailSubComponent : Injectable<DetailActivity> {

        fun inject(fragment: DetailFragment)

        @Subcomponent.Factory
        interface Factory : Injectable.Factory {

            fun create(): DetailSubComponent

        }

    }

    @Module(subcomponents = [DetailSubComponent::class])
    abstract class AppModule {

        @Binds
        @IntoMap
        @InjectableKey(DetailActivity::class)
        abstract fun provideFactory(factory: DetailSubComponent.Factory): Injectable.Factory

        @Binds
        @IntoMap
        @InjectableKey(DetailFragment::class)
        abstract fun provideFragmentFactory(factory: DetailSubComponent.Factory): Injectable.Factory

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