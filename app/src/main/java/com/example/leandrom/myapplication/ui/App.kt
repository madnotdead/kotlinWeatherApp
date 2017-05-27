package com.example.leandrom.myapplication.ui

import android.app.Application
import com.example.leandrom.myapplication.ui.utils.DelegateExt

/**
 * Created by madnotdead on 25/05/17.
 */
class App : Application() {

    companion object{
        var instance: App by DelegateExt.notNullSingleValue()
    }

    override fun onCreate() {
        super.onCreate()
        instance = this
    }
}