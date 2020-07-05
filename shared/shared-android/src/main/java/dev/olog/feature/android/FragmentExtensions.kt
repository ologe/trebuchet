package dev.olog.feature.android

import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import kotlin.properties.ReadOnlyProperty
import kotlin.reflect.KProperty

fun <T : Fragment> T.withArguments(vararg params: Pair<String, Any>): T {
    arguments = bundleOf(*params)
    return this
}

inline fun <reified T : Any> Fragment.argument(key: String): ReadOnlyProperty<Any?, T> {
    return object : ReadOnlyProperty<Any?, T> {

        override fun getValue(thisRef: Any?, property: KProperty<*>): T {
            return requireArguments().get(key) as T
        }
    }
}