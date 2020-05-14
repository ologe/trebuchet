package dev.olog.navigation.transition

import android.content.Context
import androidx.fragment.app.Fragment
import com.google.android.material.transition.Hold
import com.google.android.material.transition.MaterialContainerTransform
import com.google.android.material.transition.MaterialFadeThrough
import com.google.android.material.transition.MaterialSharedAxis
import dev.olog.navigation.R
import dev.olog.navigation.extensions.themeAttributeToColor

fun Fragment.setupExitFadeAnimation(context: Context) {
    val transition = MaterialFadeThrough.create().apply {
        duration = context.resources.getInteger(R.integer.transition_default_duration).toLong()
    }
    exitTransition = transition
    reenterTransition = transition
}

fun Fragment.setupEnterFadeAnimation(context: Context) {
    val transition = MaterialFadeThrough.create().apply {
        duration = context.resources.getInteger(R.integer.transition_default_duration).toLong()
    }
    enterTransition = transition
    returnTransition = transition
}

fun Fragment.setupExitSharedAxisAnimation(
    context: Context,
    @MaterialSharedAxis.Axis axis: Int
) {
    reenterTransition = MaterialSharedAxis.create(axis, false).apply {
        duration = context.resources.getInteger(R.integer.transition_default_duration).toLong()
    }
    exitTransition = MaterialSharedAxis.create(axis, true).apply {
        duration = context.resources.getInteger(R.integer.transition_default_duration).toLong()
    }
}

fun Fragment.setupEnterSharedAxisAnimation(
    context: Context,
    @MaterialSharedAxis.Axis axis: Int
) {
    enterTransition = MaterialSharedAxis.create(axis, true).apply {
        duration = context.resources.getInteger(R.integer.transition_default_duration).toLong()
    }
    returnTransition = MaterialSharedAxis.create(axis, false).apply {
        duration = context.resources.getInteger(R.integer.transition_default_duration).toLong()
    }
}

////////////////////// SHARED ////////////////////////////////////

fun Fragment.setupExitSharedAnimation() {
    exitTransition = Hold().apply {
        duration = resources.getInteger(R.integer.transition_enter_duration).toLong()
    }
    reenterTransition = Hold().apply {
        duration = resources.getInteger(R.integer.transition_exit_duration).toLong()
    }

}

// Fragment context can't be initialized yet, so don't use `Fragment#requireContext()`
fun Fragment.setupEnterSharedAnimation(context: Context) {
    sharedElementEnterTransition = MaterialContainerTransform().apply {
        drawingViewId = R.id.fragmentContainer
        containerColor = context.themeAttributeToColor(android.R.attr.colorBackground)
        duration = context.resources.getInteger(R.integer.transition_enter_duration).toLong()
    }
    sharedElementReturnTransition = MaterialContainerTransform().apply {
        drawingViewId = R.id.fragmentContainer
        containerColor = context.themeAttributeToColor(android.R.attr.colorBackground)
        duration = context.resources.getInteger(R.integer.transition_exit_duration).toLong()
    }
}