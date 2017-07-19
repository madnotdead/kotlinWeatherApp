package com.example.leandrom.myapplication.extensions

import android.content.Context
import android.support.v4.content.ContextCompat

/**
 * Created by madnotdead on 7/18/17.
 */
public fun Context.color(res: Int) : Int = ContextCompat.getColor(this, res)
