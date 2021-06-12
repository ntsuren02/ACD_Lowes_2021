package com.example.acd_lowes_2021.view

import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView
import com.example.acd_lowes_2021.R
import com.example.acd_lowes_2021.model.City
import com.example.acd_lowes_2021.model.WeatherData

class WeatherAdapter(
    private val city: City,
    private val weather: (WeatherData) -> Unit
) : RecyclerView.Adapter<WeatherAdapter.WeatherViewHolder>(){

    class WeatherViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val constraintLayout: ConstraintLayout = itemView.findViewById(R.id.item_layout)
        val weatherMainTextView: TextView = itemView.findViewById(R.id.weatherMain)
        val tempTextView: TextView = itemView.findViewById(R.id.temp)

        fun onBind(WeatherData: WeatherData) {
            weatherMainTextView.text = WeatherData.weather?.get(1).toString()
            tempTextView.text = "${WeatherData.main?.temp}"
        }
    }
    
    private var rowIndex = -1

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WeatherViewHolder {
        return WeatherViewHolder(LayoutInflater.from(parent.context)
            .inflate(R.layout.detail_layout, parent, false))
    }

    override fun onBindViewHolder(holder: WeatherViewHolder, position: Int) {
        holder.onBind(city.weatherData.get(position))
        holder.constraintLayout.setOnClickListener {
            rowIndex = position
            //notfyDataSetChanged()
            weather.invoke(city.weatherData.get(position))
        }
        if (rowIndex == position) {
            holder.itemView.setBackgroundColor(Color.parseColor("#adacac"))
        } else {
            holder.itemView.setBackgroundColor(Color.parseColor("#ffffff"))
        }
    }

    override fun getItemCount(): Int {
        return city.count
    }
}