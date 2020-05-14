package dev.olog.feature.presentation.base

import androidx.appcompat.app.AppCompatDelegate
import androidx.fragment.app.FragmentActivity

fun FragmentActivity.setDarkMode(enabled: Boolean) {
    val mode = if (enabled) {
        AppCompatDelegate.MODE_NIGHT_YES
    } else {
        AppCompatDelegate.MODE_NIGHT_NO
    }
    AppCompatDelegate.setDefaultNightMode(mode)
}