package dev.olog.detail.dagger

import dev.olog.detail.DetailActivity
import dev.olog.detail.DetailFragment

internal fun DetailActivity.inject(shared: DetailScreenDagger.SharedComponent) {
    shared.activityComponent()
        .create(this)
        .inject(this)
}

internal fun DetailFragment.inject(shared: DetailScreenDagger.SharedComponent) {
    shared.detailComponent()
        .create(this)
        .inject(this)
}