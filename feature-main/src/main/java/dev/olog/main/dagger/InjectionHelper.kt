package dev.olog.main.dagger

import dev.olog.core.dagger.daggerFactory
import dev.olog.main.MainActivity
import dev.olog.main.dagger.FeatureMainDagger.MainSubComponent

internal fun MainActivity.inject() {
    daggerFactory<MainSubComponent.Factory>(this)
        .create(this)
        .inject(this)
}

