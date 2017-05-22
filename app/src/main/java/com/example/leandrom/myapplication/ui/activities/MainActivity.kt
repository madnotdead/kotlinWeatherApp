package com.example.leandrom.myapplication.ui.activities

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import com.example.leandrom.myapplication.R
import com.example.leandrom.myapplication.domain.commands.RequestForecastCommand
import com.example.leandrom.myapplication.ui.adapters.ForecastListAdapter
import org.jetbrains.anko.doAsync
import org.jetbrains.anko.toast
import org.jetbrains.anko.uiThread
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)




        forecastList.layoutManager = LinearLayoutManager(this)
        forecastList.setHasFixedSize(true)


        doAsync {
            val result = RequestForecastCommand("94043").execute()
            uiThread {
                forecastList.adapter = ForecastListAdapter(result){
                    toast(it.date)
                }
            }
        }
    }
}
