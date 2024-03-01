package com.example.randomuser.data.models

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class Registered (

  @SerializedName("date")
  var date : String? = null,

  @SerializedName("age")
  var age : Int?  = null

):Parcelable