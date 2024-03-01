package com.example.randomuser.data.models

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class Coordinates (
  @SerializedName("latitude")
  var latitude  : String? = null,
  @SerializedName("longitude")
  var longitude : String? = null
):Parcelable