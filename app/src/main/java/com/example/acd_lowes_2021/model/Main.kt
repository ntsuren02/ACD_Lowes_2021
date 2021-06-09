package com.example.acd_lowes_2021.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class Main {
    @SerializedName("temp")
    @Expose
    var temp: Int? = null

    @SerializedName("feels_like")
    @Expose
    var feelsLike: Int? = null

    @SerializedName("temp_min")
    @Expose
    var tempMin: Int? = null

    @SerializedName("temp_max")
    @Expose
    var tempMax: Int? = null

    @SerializedName("pressure")
    @Expose
    var pressure: Int? = null

    @SerializedName("sea_level")
    @Expose
    var seaLevel: Int? = null

    @SerializedName("grnd_level")
    @Expose
    var grndLevel: Int? = null

    @SerializedName("humidity")
    @Expose
    var humidity: Int? = null

    @SerializedName("temp_kf")
    @Expose
    var tempKf: Int? = null
}