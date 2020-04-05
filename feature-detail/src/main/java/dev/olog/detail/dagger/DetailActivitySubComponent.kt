package dev.olog.detail.dagger

import dagger.BindsInstance
import dagger.Subcomponent
import dev.olog.core.dagger.ScreenScope
import dev.olog.core.dagger.injectable.Injectable
import dev.olog.detail.DetailActivity

@Subcomponent
@ScreenScope
internal interface DetailActivitySubComponent : Injectable<DetailActivity> {

    @Subcomponent.Factory
    interface Factory : Injectable.Factory {

        fun create(@BindsInstance instance: DetailActivity): DetailActivitySubComponent

    }

}