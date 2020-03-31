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

        @Subcomponent.Builder
        interface Builder : Injectable.Builder<DetailSubComponent>

    }

    @Module
    abstract class AppModule {

        @Binds
        @IntoMap
        @InjectableKey(DetailActivity::class)
        abstract fun provideBuilder(builder: DetailSubComponent.Builder): Injectable.Builder<*>

        @Binds
        @IntoMap
        @InjectableKey(DetailFragment::class)
        abstract fun provideFragmentBuilder(builder: DetailSubComponent.Builder): Injectable.Builder<*>

    }

    interface DetailScreenGraph {
        fun detailScreenBuilder(): DetailSubComponent.Builder
    }


}