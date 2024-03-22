package com.example.randomuser.domain.usecase

import com.example.randomuser.data.models.UserInfo
import com.example.randomuser.data.repository.GetUsersRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.Response
import javax.inject.Inject

class GetUsersUseCase @Inject constructor(private val repository: GetUsersRepository) {
    suspend operator fun invoke(numUsers: Int): Flow<Response<UserInfo>?> = flow {
        try {
            val response = repository.getUsers(numUsers = numUsers)
            emit(response)
        } catch (e: Exception) {
            emit(null)
        }
    }
}