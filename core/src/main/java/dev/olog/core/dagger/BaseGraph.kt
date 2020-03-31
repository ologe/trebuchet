package dev.olog.core.dagger

import dev.olog.core.navigation.TrebuchetKey

interface BaseGraph {

    fun trebuchetKeys(): Set<TrebuchetKey>

}

