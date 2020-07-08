package dev.olog.navigation.screens

private const val PREFIX = "dev.olog"

enum class FragmentScreen(val tag: String) {
    HOME("$PREFIX.home"),
    POKEDEX("$PREFIX.pokedex"),
    POKEDEX_DETAIL("$PREFIX.pokedex.detail"),
    MOVES("$PREFIX.moves"),
    ABILITIES("$PREFIX.abilities"),
    ITEMS("$PREFIX.items"),
    LOCATIONS("$PREFIX.locations"),
    TYPE_CHARTS("$PREFIX.type_charts"),
    NEWS("$PREFIX.news"),
    SEARCH("$PREFIX.search")
}