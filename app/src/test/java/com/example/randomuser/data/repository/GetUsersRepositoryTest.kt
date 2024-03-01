package com.example.randomuser.data.repository

import com.example.randomuser.data.models.UserInfo
import com.example.randomuser.data.network.service.GetUsersService
import kotlinx.coroutines.runBlocking
import okhttp3.ResponseBody.Companion.toResponseBody
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.mockito.MockitoAnnotations
import retrofit2.Response

class GetUsersRepositoryTest {

    // Mock the GetUsersService
    @Mock
    private lateinit var mockService: GetUsersService

    // Class under test
    private lateinit var repository: GetUsersRepository

    @Before
    fun setUp() {
        // Initialize Mockito annotations
        MockitoAnnotations.initMocks(this)

        // Initialize the repository with the mock service
        repository = GetUsersRepository(mockService)
    }

    @Test
    fun getUsers_SuccessfulResponse() {
        // Mock successful response
        val userInfo = UserInfo(/* Populate with test data */)
        val response = Response.success(userInfo)
        `when`(runBlocking { mockService.getUsers(numUsers = 10) }).thenReturn(response)

        // Call the method under test
        val result = runBlocking { repository.getUsers(numUsers = 10) }

        // Verify the result
        assertEquals(response, result)
    }

    @Test
    fun getUsers_FailureResponse() {
        // Mock failure response
        val errorMessage = "Error message"
        val response = Response.error<UserInfo>(404, errorMessage.toResponseBody())

        `when`(runBlocking { mockService.getUsers(numUsers = 10) }).thenReturn(response)

        // Call the method under test
        val result = runBlocking { repository.getUsers(numUsers = 10) }

        // Verify the result
        assertEquals(response, result)
    }
}