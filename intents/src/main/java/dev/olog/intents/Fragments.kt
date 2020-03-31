package dev.olog.intents

import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment

object Fragments {

    const val DETAIL_FRAGMENT = "dev.olog.detail.DetailFragment"

    fun toDetailFragment(listingId: Int): Fragment? {
        val args = bundleOf(
            "listingId" to listingId
        )
        return loadClassOrNull<Fragment>(DETAIL_FRAGMENT)
            ?.newInstance()
            ?.apply { arguments = args }
    }

}