package com.example.randomuser.data.models

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class Id (
  @SerializedName("name")
  var name  : String? = null,
  @SerializedName("value")
  var value : String? = null
):Parcelable