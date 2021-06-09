package com.example.acd_lowes_2021.view

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.acd_lowes_2021.R
import com.example.acd_lowes_2021.model.WeatherData

class WeatherAdapter(
    private val weatherList: List<WeatherData>,
    private val weatherDelegate: WeatherDelegate
) :
    RecyclerView.Adapter<WeatherAdapter.WeatherViewHolder>() {
    interface WeatherDelegate {
        fun selectWeather(weatherData: WeatherData?)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WeatherViewHolder {
        val itemView: View = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_layout, parent, false)
        return WeatherViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: WeatherViewHolder, position: Int) {
        val item = weatherList[position]
        holder.weatherMainTextView.setText(item.weather?.get(1).toString())
        item.main?.temp?.let { holder.tempTextView.setText(it) }
        holder.itemView.setOnClickListener { view: View? ->
            weatherDelegate.selectWeather(
                item
            )
        }
    }

    override fun getItemCount(): Int {
        return weatherList.size
    }

    inner class WeatherViewHolder(itemView: View) :
        RecyclerView.ViewHolder(itemView) {
        var weatherMainTextView: TextView
        var tempTextView: TextView

        init {
            weatherMainTextView = itemView.findViewById(R.id.weatherMain)
            tempTextView = itemView.findViewById(R.id.temp)
        }
    }
}