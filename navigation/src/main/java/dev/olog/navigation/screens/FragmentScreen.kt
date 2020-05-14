package dev.olog.navigation.screens

private const val PREFIX = "dev.olog"

// TODO exposes fragment tags
enum class FragmentScreen(val tag: String) {
    LOGIN("$PREFIX.login"),
    MAIN("$PREFIX.main"),
    DETAIL("$PREFIX.detail")
}