package dev.olog.detail.dagger

import dagger.Module
import dagger.Provides
import dev.olog.core.dagger.FeatureScope

@Module
class SharedDetailModule {

    @Provides
    @FeatureScope
    fun provideString(): String {
        return "detail"
    }

}