package dev.olog.intents

private val CLASS_MAP = mutableMapOf<String, Class<*>>()

private fun <T> Class<*>.castOrNull(): Class<T>? {
    try {
        @Suppress("UNCHECKED_CAST")
        return this as Class<T>
    } catch (ex: ClassCastException) {
        ex.printStackTrace()
        return null
    }
}

internal fun <T> loadClassOrNull(className: String): Class<T>? {
    return CLASS_MAP.getOrPut(className) {
        try {
            Class.forName(className)
        } catch (ex: ClassNotFoundException) {
            ex.printStackTrace()
            return null
        }
    }.castOrNull()
}