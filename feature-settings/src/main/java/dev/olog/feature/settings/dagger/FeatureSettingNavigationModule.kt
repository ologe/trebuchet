package dev.olog.feature.settings.dagger

import android.content.Context
import android.content.Intent
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.multibindings.IntoMap
import dev.olog.feature.settings.SettingsActivity
import dev.olog.navigation.dagger.ActivityScreenKey
import dev.olog.navigation.screens.ActivityScreen

@Module
@InstallIn(ApplicationComponent::class)
internal class FeatureSettingNavigationModule {

    @Provides
    @IntoMap
    @ActivityScreenKey(ActivityScreen.SETTINGS)
    internal fun provideActivity(@ApplicationContext context: Context): Intent {
        return Intent(context, SettingsActivity::class.java)
    }

}