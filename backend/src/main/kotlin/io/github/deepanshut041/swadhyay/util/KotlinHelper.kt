package io.github.deepanshut041.swadhyay.util

inline fun <reified T : Enum<T>> valueOf(type: String, default: T): T {
    return try {
        java.lang.Enum.valueOf(T::class.java, type)
    } catch (e: Exception) {
        default
    }
}
