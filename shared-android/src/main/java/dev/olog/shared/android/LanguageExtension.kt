package dev.olog.shared.android

// TODO move to :shared

inline fun <T> lazyFast(crossinline operation: () -> T): Lazy<T> = lazy(LazyThreadSafetyMode.NONE) {
    operation()
}

inline val <T> T.exhaustive: T
    get() = this