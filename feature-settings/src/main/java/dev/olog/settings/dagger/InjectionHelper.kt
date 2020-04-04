package dev.olog.settings.dagger

import dev.olog.core.dagger.daggerFactory
import dev.olog.settings.SettingsActivity
import dev.olog.settings.dagger.FeatureSettingsDagger.SettingsSubComponent

internal fun SettingsActivity.inject() {
    daggerFactory<SettingsSubComponent.Factory>(this)
        .create(this)
        .inject(this)
}