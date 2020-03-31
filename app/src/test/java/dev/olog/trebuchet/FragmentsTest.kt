package dev.olog.trebuchet

import dev.olog.detail.DetailFragment
import dev.olog.intents.Fragments
import org.junit.Assert.assertEquals
import org.junit.Test

class FragmentsTest {

    @Test
    fun `test detail`() {
        assertEquals(DetailFragment::class.java.name, Fragments.DETAIL_FRAGMENT)
    }

}