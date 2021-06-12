package com.example.acd_lowes_2021.view

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.example.acd_lowes_2021.model.WeatherData
import com.example.acd_lowes_2021.R

private const val TAG = "DetailFragment"
private const val ARG_PARAM1 = "param1"

class WeatherFragment : Fragment() {
    private var param1: WeatherData? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getParcelable(ARG_PARAM1)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        Log.d(TAG, "onCreateView: ")
        return inflater.inflate(
            R.layout.detail_layout, container,false).also{
                v -> arguments?.getParcelable<WeatherData>(ARG_PARAM1)?.let {
                    Log.d(TAG, "onCreateView: input: $it")
                    v.findViewById<TextView>(R.id.temp).text = "${it.main?.temp}"
                    v.findViewById<TextView>(R.id.feels_like).text = "${it.main?.feelsLike}"
                    v.findViewById<TextView>(R.id.weatherMain).text = "${it.weather?.get(0)?.main}"
                    v.findViewById<TextView>(R.id.weatherDescription).text = "${it.weather?.get(1)?.description}"
                }
            }
        }

    companion object {
        fun newInstance(weatherData: WeatherData) = WeatherFragment().apply {
                arguments = Bundle().apply {
                    putParcelable(ARG_PARAM1, weatherData)
                }
            }
    }
}