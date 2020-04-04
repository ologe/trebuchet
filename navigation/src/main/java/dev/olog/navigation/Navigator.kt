package dev.olog.navigation

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.fragment.app.FragmentTransaction

interface Navigator {

    fun toDetail(activity: FragmentActivity, listingId: Long)

    fun toDetailFragment(
        activity: FragmentActivity,
        listingId: Long,
        block: FragmentTransaction.(Fragment) -> FragmentTransaction
    )

    fun toSettings(activity: FragmentActivity)

}