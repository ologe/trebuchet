package dev.olog.detail.dagger

import dagger.Binds
import dagger.Module
import dagger.android.AndroidInjector
import dagger.multibindings.ClassKey
import dagger.multibindings.IntoMap
import dev.olog.detail.DetailFragment

@Module(
    subcomponents = [
        DetailFragmentSubComponent::class
    ]
)
abstract class SubComponents {

    @Binds
    @IntoMap
    @ClassKey(DetailFragment::class)
    internal abstract fun provideActivityFactory(factory: DetailFragmentSubComponent.Factory): AndroidInjector.Factory<*>

}