package dev.olog.feature.components.widget

import android.annotation.SuppressLint
import android.content.Context
import android.util.AttributeSet
import android.widget.ImageView
import dev.olog.feature.components.R

@SuppressLint("AppCompatCustomView") // AppCompatImageView does not have defStyleRes
class PokeballBackground(
    context: Context,
    attrs: AttributeSet
) : ImageView(context, attrs, 0,
    R.style.PokeballBackground
)