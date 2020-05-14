package dev.olog.feature.presentation.base

import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class AppPreferences @Inject constructor() {

    private var isDarkMode: Boolean = false

    fun isDarkMode() = isDarkMode

    fun setDarkMode(enabled: Boolean) {
        isDarkMode = enabled
    }

}