package com.example.randomuser.data.models

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class Street (
  @SerializedName("number" )
  var number : Int? = null,

  @SerializedName("name")
  var name   : String? = null
):Parcelable