package com.example.acd_lowes_2021.model

import android.os.Parcelable
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
class Clouds: Parcelable {
    @SerializedName("all")
    @Expose
    val all: Int? = null
}