package com.example.acd_lowes_2021.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.FrameLayout
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.acd_lowes_2021.model.WeatherData
import com.example.acd_lowes_2021.R
import com.example.acd_lowes_2021.model.City

const val KEY_FORECAST_ITEM = "KEY_FORECAST_ITEM"
const val KEY_CITY_NAME = "KEY_CITY_NAME"

private const val TAG = "RecyclerActivity"

class RecyclerActivity : AppCompatActivity() {
    lateinit var recyclerView: RecyclerView
    lateinit var intent2: Intent

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.recycler_layout)

        recyclerView = findViewById(R.id.recyclerview)
        intent.getParcelableExtra<City>(KEY_FORECAST)?.let {
            recyclerView.layoutManager = GridLayoutManager(this, 1)
            recyclerView.adapter = WeatherAdapter(it, ::openDetail)
            title = it.name
            intent2 = Intent(this, DetailActivity::class.java)
            intent2.putExtra(KEY_CITY_NAME, it.name)
        }
    }

    private fun openDetail(weatherData: WeatherData) {
        Log.d(TAG, "openDetail:input: $weatherData")
        val fl = findViewById<FrameLayout>(R.id.fl_fragment_detail_container)
        Log.d(TAG, "openDetail: $fl")
        if(fl == null){
            intent2.putExtra(KEY_FORECAST_ITEM, weatherData)
            startActivity(intent2)
        }else{
            val fragment = WeatherFragment()
            supportFragmentManager.beginTransaction()
                .replace(R.id.fl_fragment_detail_container, fragment)
                .commit()
        }
    }
}