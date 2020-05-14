package dev.olog.navigation

import android.content.Intent
import android.graphics.Color
import android.view.View
import androidx.annotation.IdRes
import androidx.appcompat.app.AppCompatDialogFragment
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.fragment.app.FragmentTransaction
import androidx.fragment.app.commit
import com.google.android.material.snackbar.Snackbar

private const val NEXT_REQUEST_THRESHOLD: Long = 400 // ms

internal abstract class BaseNavigator {

    private var lastRequest: Long = -1

    protected fun replaceFragment(
        activity: FragmentActivity,
        fragment: Fragment?,
        tag: String,
        @IdRes containerId: Int = R.id.fragmentContainer,
        forced: Boolean = false,
        block: FragmentTransaction.(Fragment) -> Any? = {}
    ) {
        mandatory(activity, fragment != null, forced) ?: return

        if (fragment is AppCompatDialogFragment) {
            fragment.show(activity.supportFragmentManager, tag)
            return
        }

        activity.supportFragmentManager.commit {
            setReorderingAllowed(true)
            replace(containerId, fragment!!, tag)
            block(fragment)
        }
    }

    protected fun startActivity(activity: FragmentActivity, intent: Intent?) {
        mandatory(activity, intent != null) ?: return
        activity.startActivity(intent)
    }

    /**
     * @param forced, skips [allowed] check
     */
    protected fun mandatory(
        activity: FragmentActivity,
        condition: Boolean,
        forced: Boolean = false
    ): Unit? {
        if (!forced && !allowed()) {
            // avoid click spam
            return null
        }
        if (condition) {
            return Unit
        }

        val rootView = activity.findViewById<View>(android.R.id.content)

        val snackBar = Snackbar.make(rootView, "Module not plugged", Snackbar.LENGTH_SHORT)
        snackBar.view.setBackgroundColor(Color.parseColor("#bf485a"))
        snackBar.show()

        return null
    }

    private fun allowed(): Boolean {
        val allowed = (System.currentTimeMillis() - lastRequest) > NEXT_REQUEST_THRESHOLD
        lastRequest = System.currentTimeMillis()
        return allowed
    }

}