package com.example.leandrom.myapplication.extensions

import android.content.Context
import android.view.View
import android.widget.TextView

/**
 * Created by madnotdead on 7/18/17.
 */

val View.ctx: Context
    get() = context

var TextView.textColor: Int
    get() = currentTextColor
    set(v) = setTextColor(v)