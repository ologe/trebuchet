package dev.olog.navigation

import android.app.Activity
import android.content.Intent
import android.graphics.Color
import android.view.View
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.fragment.app.FragmentTransaction
import com.google.android.material.snackbar.Snackbar
import dev.olog.navigation.screens.ActivityScreen
import dev.olog.navigation.screens.FragmentScreen
import javax.inject.Inject
import javax.inject.Provider

internal class NavigatorImpl @Inject constructor(
    private val activitiesMap: Map<ActivityScreen, @JvmSuppressWildcards Provider<Intent>>,
    private val fragmentsMap: Map<FragmentScreen, @JvmSuppressWildcards Provider<Fragment>>
) : Navigator {

    override fun toDetail(
        activity: FragmentActivity,
        listingId: Long
    ) {
        val intent = activitiesMap[ActivityScreen.DETAIL]?.get()
        val bundle = bundleOf(
            Params.LISTING_ID to listingId
        )
        intent?.putExtras(bundle)
        startActivity(activity, intent)
    }

    override fun toDetailFragment(
        activity: FragmentActivity,
        listingId: Long,
        block: FragmentTransaction.(Fragment) -> FragmentTransaction
    ) {
        val fragment = fragmentsMap[FragmentScreen.DETAIL]?.get()
        fragment?.arguments = bundleOf(
            Params.LISTING_ID to listingId
        )
        replaceFragment(activity, fragment, block)
    }

    override fun toSettings(activity: FragmentActivity) {
        val intent = activitiesMap[ActivityScreen.SETTINGS]?.get()
        startActivity(activity, intent)
    }

    private fun startActivity(activity: FragmentActivity, intent: Intent?) {
        mandatory(activity, intent != null) ?: return

        activity.startActivity(intent)
    }

    private fun replaceFragment(
        activity: FragmentActivity,
        fragment: Fragment?,
        block: FragmentTransaction.(Fragment) -> FragmentTransaction
    ) {
        mandatory(activity, fragment != null) ?: return

        activity.supportFragmentManager.beginTransaction()
            .block(fragment!!)
            .commit()
    }

    private fun mandatory(activity: Activity, condition: Boolean): Unit? {
        if (condition) {
            return Unit
        }

        val rootView = activity.findViewById<View>(android.R.id.content)
        val snackbar = Snackbar.make(rootView, "Module not plugged", Snackbar.LENGTH_LONG)

        snackbar.view.setBackgroundColor(Color.parseColor("#bf485a"))

        snackbar.show()

        return null
    }

}