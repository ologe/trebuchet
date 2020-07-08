package dev.olog.trebuchet

import android.app.Application
import dagger.hilt.android.HiltAndroidApp
import dev.olog.navigation.utils.ActivityProvider
import javax.inject.Inject

@HiltAndroidApp
class App : Application() {

    @Inject
    lateinit var activityProvider: ActivityProvider

}