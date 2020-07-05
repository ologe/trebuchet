package dev.olog.feature.components.theme

import android.content.Context
import android.content.res.ColorStateList
import android.graphics.Color
import android.util.TypedValue
import androidx.annotation.AttrRes
import androidx.annotation.ColorInt

@Suppress("NOTHING_TO_INLINE")
inline fun Context.colorBackground(): ColorStateList {
    return themeAttributeToStateList(android.R.attr.colorBackground)
}

fun Context.themeAttributeToStateList(
    @AttrRes themeAttributeId: Int,
    @ColorInt fallbackColor: Int = Color.MAGENTA
): ColorStateList {
    val outValue = TypedValue()
    val theme = this.theme
    val resolved = theme.resolveAttribute(themeAttributeId, outValue, true)
    if (resolved) {
        val a = obtainStyledAttributes(outValue.resourceId, intArrayOf(themeAttributeId))
        val colorStateList = a.getColorStateList(0)
        a.recycle()
        if (colorStateList != null) {
            return colorStateList
        }
    }
    return ColorStateList.valueOf(fallbackColor)
}