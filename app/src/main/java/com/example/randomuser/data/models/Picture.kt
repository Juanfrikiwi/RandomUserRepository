package com.example.randomuser.data.models

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class Picture (
  @SerializedName("large")
  var large : String? = null,

  @SerializedName("medium" )
  var medium  : String? = null,

  @SerializedName("thumbnail" )
  var thumbnail : String? = null

):Parcelable