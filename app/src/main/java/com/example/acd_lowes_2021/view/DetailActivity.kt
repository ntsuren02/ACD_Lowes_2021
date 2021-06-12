package com.example.acd_lowes_2021.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.TextView
import com.example.acd_lowes_2021.model.WeatherData
import com.example.acd_lowes_2021.R

class DetailActivity : AppCompatActivity() {
    lateinit var temp: TextView
    lateinit var feelsLike: TextView
    lateinit var condition: TextView
    lateinit var description: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.detail_layout)

        temp = findViewById(R.id.temp)
        feelsLike = findViewById(R.id.feels_like)
        condition = findViewById(R.id.weatherMain)
        description = findViewById(R.id.weatherDescription)

        intent.getParcelableExtra<WeatherData>(KEY_FORECAST_ITEM)?.let {
            temp.text = "${it.main?.temp}"
            feelsLike.text = "Feels Like: ${it.main?.feelsLike}"
            condition.text = "${it.weather?.get(0)?.main}"
            description.text = "${it.weather?.get(1)?.description}"
        }
        intent.getStringExtra("city")?.let {
            title = it
        }
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            android.R.id.home -> {
                onBackPressed()
                return true
            }
        }
        return super.onOptionsItemSelected(item)
    }
}