package com.example.randomuser.data.network.api

import com.example.randomuser.data.models.UserInfo
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface GetUsersApiClient {

    @GET("api")
    suspend fun getUsersApiClient(
        @Query("results") numUsers: Int,
    ):Response<UserInfo>


}