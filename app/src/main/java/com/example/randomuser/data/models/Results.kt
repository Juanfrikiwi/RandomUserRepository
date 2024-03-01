package com.example.randomuser.data.models

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class Results(
    @SerializedName("gender")
    var gender: String? = null,

    @SerializedName("name")
    var name: Name = Name(),

    @SerializedName("location")
    var location: Location? = Location(),

    @SerializedName("email")
    var email: String = "",

    @SerializedName("login")
    var login: Login? = Login(),

    @SerializedName("dob")
    var dob: Dob? = Dob(),

    @SerializedName("registered")
    var registered: Registered? = Registered(),

    @SerializedName("phone")
    var phone: String? = null,

    @SerializedName("cell")
    var cell: String? = null,

    @SerializedName("id")
    var id: Id? = Id(),

    @SerializedName("picture")
    var picture: Picture? = Picture(),

    @SerializedName("nat")
    var nat: String? = null

):Parcelable