package com.example.acd_lowes_2021.model

import android.os.Parcelable
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
class Weather: Parcelable {
    @SerializedName("id")
    @Expose
    val id: Int? = null

    @SerializedName("main")
    @Expose
    val main: String? = null

    @SerializedName("description")
    @Expose
    val description: String? = null

    @SerializedName("icon")
    @Expose
    val icon: String? = null
}
