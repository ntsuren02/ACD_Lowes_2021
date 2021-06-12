package com.example.acd_lowes_2021.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
class City(val name: String, val weatherData: List<WeatherData>, val count: Int): Parcelable {

}
