package com.example.leandrom.myapplication.extensions

/**
 * Created by madnotdead on 7/15/17.
 */
inline fun <T, R : Any> Iterable<T>.firstResult(predicate: (T) -> R?): R {
    for (element in this) {
        val result = predicate(element)
        if (result != null) return result
    }
    throw NoSuchElementException("No element matching predicate was found.")
}

