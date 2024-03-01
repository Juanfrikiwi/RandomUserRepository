package com.example.randomuser.domain.usecase

import com.example.randomuser.data.models.UserInfo
import com.example.randomuser.data.repository.GetUsersRepository
import retrofit2.Response
import javax.inject.Inject

class GetUsersUseCase @Inject constructor(private val repository: GetUsersRepository) {
    suspend operator fun invoke(numUsers:Int): Response<UserInfo>? {
        return try {
            repository.getUsers(numUsers = numUsers)
        }catch (e:Exception){
            null
        }
    }
}