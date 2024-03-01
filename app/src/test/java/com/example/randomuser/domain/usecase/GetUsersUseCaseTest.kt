package com.example.randomuser.domain.usecase

import com.example.randomuser.data.models.UserInfo
import com.example.randomuser.data.repository.GetUsersRepository
import kotlinx.coroutines.runBlocking
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNotNull
import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito.mock
import org.mockito.Mockito.`when`
import org.mockito.MockitoAnnotations
import retrofit2.Response

class GetUsersUseCaseTest {

    @Mock
    private lateinit var repository: GetUsersRepository

    private lateinit var getUsersUseCase: GetUsersUseCase

    @Before
    fun setUp() {
        MockitoAnnotations.openMocks(this)
        getUsersUseCase = GetUsersUseCase(repository)
    }

    @Test
    fun `invokeWithValidNumberOfUsersShouldReturnResponse`() {
        runBlocking {
            // Given
            val numUsers = 10
            val expectedResponse: Response<UserInfo> = mockResponse()

            `when`(repository.getUsers(numUsers)).thenReturn(expectedResponse)

            // When
            val response = getUsersUseCase(numUsers)

            // Then
            assertNotNull(response)
            assertEquals(expectedResponse, response)
        }
    }

    @Test
    fun `invokeWithExceptionShouldReturnNull`() {
        runBlocking {
            // Given
            val numUsers = 10

            `when`(repository.getUsers(numUsers)).thenThrow(RuntimeException("Error"))

            // When
            val response = getUsersUseCase(numUsers)

            // Then
            assertEquals(null, response)
        }
    }

    private fun mockResponse(): Response<UserInfo> {
        // Mock a response object
        return mock(Response::class.java) as Response<UserInfo>
    }
}