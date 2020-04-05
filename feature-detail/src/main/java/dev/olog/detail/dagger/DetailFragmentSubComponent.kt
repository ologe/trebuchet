package dev.olog.detail.dagger

import dagger.Subcomponent
import dagger.android.AndroidInjector
import dev.olog.core.dagger.ScreenScope
import dev.olog.detail.DetailFragment

@Subcomponent
@ScreenScope
internal interface DetailFragmentSubComponent : AndroidInjector<DetailFragment> {

    @Subcomponent.Factory
    interface Factory : AndroidInjector.Factory<DetailFragment>

}