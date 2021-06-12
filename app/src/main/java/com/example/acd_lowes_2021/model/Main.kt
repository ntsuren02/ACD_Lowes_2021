package com.example.acd_lowes_2021.model

import android.os.Parcelable
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
class Main: Parcelable {
    @SerializedName("temp")
    @Expose
    val temp: Int? = null

    @SerializedName("feels_like")
    @Expose
    val feelsLike: Int? = null

    @SerializedName("temp_min")
    @Expose
    val tempMin: Int? = null

    @SerializedName("temp_max")
    @Expose
    val tempMax: Int? = null

    @SerializedName("pressure")
    @Expose
    val pressure: Int? = null

    @SerializedName("sea_level")
    @Expose
    val seaLevel: Int? = null

    @SerializedName("grnd_level")
    @Expose
    val grndLevel: Int? = null

    @SerializedName("humidity")
    @Expose
    val humidity: Int? = null

    @SerializedName("temp_kf")
    @Expose
    val tempKf: Int? = null
}