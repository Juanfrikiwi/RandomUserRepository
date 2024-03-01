package com.example.randomuser.data.models

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class Name (
  @SerializedName("title")
  var title : String = "",

  @SerializedName("first")
  var first : String = "",

  @SerializedName("last")
  var last  : String = ""

):Parcelable