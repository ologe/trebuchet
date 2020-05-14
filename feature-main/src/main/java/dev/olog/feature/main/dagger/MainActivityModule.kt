package dev.olog.feature.main.dagger

import dagger.Module
import dagger.android.ContributesAndroidInjector
import dev.olog.core.dagger.FeatureScope
import dev.olog.feature.main.MainFragment

@Module
internal abstract class MainActivityModule {

    @ContributesAndroidInjector
    @FeatureScope
    abstract fun provideFragment(): MainFragment

}