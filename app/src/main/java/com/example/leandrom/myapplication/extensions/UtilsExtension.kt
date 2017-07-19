package com.example.leandrom.myapplication.extensions

import java.text.DateFormat
import java.util.*

/**
 * Created by madnotdead on 7/18/17.
 */



public fun Long.toDateString(dateFormat: Int = DateFormat.MEDIUM): String {
    val df = DateFormat.getDateInstance(dateFormat, Locale.getDefault())
    return df.format(this)
}
