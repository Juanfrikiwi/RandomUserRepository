package com.example.randomuser.data.models

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class Info (
  @SerializedName("seed")
  var seed : String? = null,
  @SerializedName("results")
  var results : Int? = null,
  @SerializedName("page")
  var page : Int?  = null,
  @SerializedName("version")
  var version : String? = null
):Parcelable