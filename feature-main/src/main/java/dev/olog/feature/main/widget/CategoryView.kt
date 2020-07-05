package dev.olog.feature.main.widget

import android.content.Context
import android.content.res.TypedArray
import android.graphics.Color
import android.os.Build
import android.util.AttributeSet
import android.view.View
import androidx.core.content.withStyledAttributes
import com.google.android.material.card.MaterialCardView
import dev.olog.feature.main.R
import dev.olog.shared.android.dipf
import kotlinx.android.synthetic.main.layout_category.view.*

class CategoryView(
    context: Context,
    attrs: AttributeSet
) : MaterialCardView(context, attrs) {

    init {
        View.inflate(context, R.layout.layout_category, this)

        setup()

        context.withStyledAttributes(attrs, R.styleable.CategoryView) {
            bindText(this)
            bindTint(this)
        }
    }

    private fun setup() {
        cardElevation = context.dipf(12)
        shapeAppearanceModel = shapeAppearanceModel.withCornerSize(context.dipf(12))
    }

    private fun bindText(a: TypedArray) {
        val text = a.getString(R.styleable.CategoryView_android_text)
        if (text != null) {
            description.text = text
        } else {
            description.text = "UNSET"
        }
    }

    private fun bindTint(a: TypedArray) {
        val color = a.getColor(R.styleable.CategoryView_android_tint, Color.MAGENTA)
        setCardBackgroundColor(color)

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.P) {
            outlineAmbientShadowColor = color
            outlineSpotShadowColor = color
        }
    }

}