package com.example.acd_lowes_2021.view

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import com.example.acd_lowes_2021.R
import com.example.acd_lowes_2021.model.WebAPI

const val KEY_FORECAST = "KEY_FORECAST"

class MainActivity : AppCompatActivity() {
    private val webAPI: WebAPI = WebAPI()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        LookupButton()
    }

    private fun LookupButton() {
        val lookupButton = findViewById<Button>(R.id.lookup_button)
        lookupButton.setOnClickListener {
            val editCity = findViewById<EditText>(R.id.city)
            val city = editCity.toString()
            setContentView(R.layout.recycler_layout)
            webAPI.retrieveForecast(city)
        }
    }
}