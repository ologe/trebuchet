package dev.olog.shared.android

import android.content.Context

@Suppress("NOTHING_TO_INLINE")
inline fun Context.dip(value: Int): Int = (value * resources.displayMetrics.density).toInt()

@Suppress("NOTHING_TO_INLINE")
inline fun Context.dipf(value: Int): Float = (value * resources.displayMetrics.density)
