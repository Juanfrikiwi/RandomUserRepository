package com.example.randomuser.data.models

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class Timezone(
    @SerializedName("offset")
    var offset: String? = null,

    @SerializedName("description")
    var description: String? = null

) : Parcelable