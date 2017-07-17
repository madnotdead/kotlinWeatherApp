package com.example.leandrom.myapplication.extensions

/**
 * Created by madnotdead on 7/15/17.
 */
fun <K, V : Any> MutableMap<K, V?>.toVarargArray():
        Array<out Pair<K, V>> = map({ Pair(it.key, it.value!!) }).toTypedArray()