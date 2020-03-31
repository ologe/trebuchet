package dev.olog.detail

import dagger.Binds
import dagger.Module
import dagger.Subcomponent
import dagger.multibindings.IntoMap
import dev.olog.core.dagger.FeatureScope
import dev.olog.core.dagger.injectable.Injectable
import dev.olog.core.dagger.injectable.InjectableKey

class DetailScreenDagger {

    @Subcomponent
    @FeatureScope
    interface DetailSubComponent : Injectable<DetailActivity> {

        fun inject(fragment: DetailFragment)

        @Subcomponent.Factory
        interface Factory : Injectable.Factory<DetailSubComponent> {

            fun create(): DetailSubComponent

        }

    }

    @Module
    abstract class AppModule {

        @Binds
        @IntoMap
        @InjectableKey(DetailActivity::class)
        abstract fun provideFactory(factory: DetailSubComponent.Factory): Injectable.Factory<*>

        @Binds
        @IntoMap
        @InjectableKey(DetailFragment::class)
        abstract fun provideFragmentFactory(factory: DetailSubComponent.Factory): Injectable.Factory<*>

    }

    interface DetailScreenGraph {
        fun detailScreenFactory(): DetailSubComponent.Factory
    }


}