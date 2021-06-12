package com.example.acd_lowes_2021.model

import android.os.Parcelable
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
class Sys: Parcelable {
    @SerializedName("pod")
    @Expose
    val pod: String? = null
}
