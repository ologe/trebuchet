package dev.olog.detail.dagger

import dagger.BindsInstance
import dagger.Subcomponent
import dev.olog.core.dagger.ScreenScope
import dev.olog.core.dagger.injectable.Injectable
import dev.olog.detail.DetailFragment

@Subcomponent
@ScreenScope
internal interface DetailFragmentSubComponent : Injectable<DetailFragment> {

    @Subcomponent.Factory
    interface Factory : Injectable.Factory {

        fun create(@BindsInstance instance: DetailFragment): DetailFragmentSubComponent

    }

}