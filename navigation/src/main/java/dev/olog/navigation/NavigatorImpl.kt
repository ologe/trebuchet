package dev.olog.navigation

import android.app.Activity
import android.content.Intent
import android.graphics.Color
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import com.google.android.material.snackbar.Snackbar
import javax.inject.Inject
import kotlin.contracts.contract

internal class NavigatorImpl @Inject constructor(

) : Navigator {

    override fun startActivity(activity: FragmentActivity, intent: Intent?) {
        mandatory(activity, intent != null) ?: return

        activity.startActivity(intent)
    }

    override fun replaceFragment(
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