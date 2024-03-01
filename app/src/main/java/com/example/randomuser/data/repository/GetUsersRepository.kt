package com.example.randomuser.data.repository

import com.example.randomuser.data.models.UserInfo
import com.example.randomuser.data.network.service.GetUsersService
import retrofit2.Response
import javax.inject.Inject



class GetUsersRepository @Inject constructor(
    private val service: GetUsersService,
) {
    suspend fun getUsers(numUsers:Int): Response<UserInfo> {
        return service.getUsers(numUsers=numUsers)
    }
}