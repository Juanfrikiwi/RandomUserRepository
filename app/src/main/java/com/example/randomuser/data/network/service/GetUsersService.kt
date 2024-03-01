package com.example.randomuser.data.network.service

import com.example.randomuser.data.models.UserInfo
import com.example.randomuser.data.network.api.GetUsersApiClient
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.Response
import javax.inject.Inject

class GetUsersService @Inject constructor(private val apiClient: GetUsersApiClient) {

    suspend fun getUsers(numUsers:Int): Response<UserInfo> {
        return  withContext(Dispatchers.IO) {
            val response = apiClient.getUsersApiClient(numUsers = numUsers)
            response
        }
    }
}