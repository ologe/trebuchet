package dev.olog.navigation

import android.content.Intent
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.fragment.app.FragmentTransaction

interface Navigator {

    fun startActivity(activity: FragmentActivity, intent: Intent?)

    fun replaceFragment(
        activity: FragmentActivity,
        fragment: Fragment?,
        block: FragmentTransaction.(Fragment) -> FragmentTransaction
    )

}