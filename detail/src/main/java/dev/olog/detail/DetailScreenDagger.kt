package dev.olog.detail

import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.Subcomponent
import dagger.multibindings.IntoMap
import dagger.multibindings.IntoSet
import dev.olog.core.dagger.FeatureScope
import dev.olog.core.dagger.injectable.Injectable
import dev.olog.core.dagger.injectable.InjectableKey
import dev.olog.core.navigation.TrebuchetKey

class DetailScreenDagger {

    @Subcomponent
    @FeatureScope
    interface DetailSubComponent :
        Injectable<DetailActivity> {

        @Subcomponent.Builder
        interface Builder : Injectable.Builder<DetailSubComponent>

    }

    @Module
    abstract class AppModule {

        @Binds
        @IntoMap
        @InjectableKey(DetailActivity::class)
        abstract fun provideBuilder(builder: DetailSubComponent.Builder): Injectable.Builder<*>

        companion object {
            @Provides
            @IntoSet
            fun provideTrebuchetKeys(): TrebuchetKey {
                return object : TrebuchetKey("detail") {}
            }
        }

    }

    interface DetailScreenGraph {
        fun detailScreenBuilder(): DetailSubComponent.Builder
    }


}