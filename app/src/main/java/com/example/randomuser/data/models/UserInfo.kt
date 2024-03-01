package com.example.randomuser.data.models

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class UserInfo(

    @SerializedName("results")
    var results: List<Results> = arrayListOf(),

    @SerializedName("info")
    var info: Info? = Info()

):Parcelable