package dev.olog.detail.dagger

import dev.olog.core.dagger.daggerFactory
import dev.olog.detail.DetailActivity
import dev.olog.detail.DetailFragment
import dev.olog.detail.dagger.DetailScreenDagger.DetailActivitySubComponent

internal fun DetailActivity.inject() {
    daggerFactory<DetailActivitySubComponent.Factory>(this)
        .create()
        .inject(this)
}

internal fun DetailFragment.inject() {
    daggerFactory<DetailScreenDagger.DetailFragmentSubComponent.Factory>(requireContext())
        .create()
        .inject(this)
}