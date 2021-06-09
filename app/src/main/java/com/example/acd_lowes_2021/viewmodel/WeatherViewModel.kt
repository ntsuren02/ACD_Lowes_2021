package com.example.acd_lowes_2021.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.acd_lowes_2021.model.Weather
import com.example.acd_lowes_2021.model.WeatherData

class WeatherViewModel: ViewModel() {

    private val mutableLiveDataWeather = MutableLiveData<Weather>()
    private val mutableLiveDataWeatherData = MutableLiveData<WeatherData>()

    fun getWeather(): LiveData<Weather> = mutableLiveDataWeather
    fun getWeatherData(): LiveData<WeatherData> = mutableLiveDataWeatherData

    override fun onCleared() {
        super.onCleared()
    }
}