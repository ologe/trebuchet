package dev.olog.navigation.utils

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager

val FragmentManager.topFragment: Fragment?
    get() {
        val topFragment = this.backStackEntryCount - 1
        if (topFragment > -1) {
            val tag = this.getBackStackEntryAt(topFragment).name
            return this.findFragmentByTag(tag)
        }
        return null
    }
