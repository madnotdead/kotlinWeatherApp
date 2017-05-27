package com.example.leandrom.myapplication.ui.utils

import kotlin.reflect.KProperty

/**
 * Created by madnotdead on 26/05/17.
 */

object DelegateExt{
    fun <T> notNullSingleValue() = NotNullSingleValueVar<T>()
}

class NotNullSingleValueVar<T>{

    private var value: T? = null

    operator fun getValue(thisRef: Any?, property: KProperty<*>): T {
        return value ?: throw IllegalStateException("${property.name} " + "not initialized")
    }

    operator fun setValue(thisRef: Any?, property: KProperty<*>, value: T){
        this.value = if(value == null) value
        else throw IllegalStateException("${property.name} already initialized")
    }
}