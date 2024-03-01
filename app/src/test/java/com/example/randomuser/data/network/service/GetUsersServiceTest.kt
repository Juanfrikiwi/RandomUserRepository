package com.example.randomuser.data.network.service

import com.example.randomuser.data.models.UserInfo
import com.example.randomuser.data.network.api.GetUsersApiClient
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.test.TestCoroutineDispatcher
import kotlinx.coroutines.test.UnconfinedTestDispatcher
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.setMain
import okhttp3.MediaType.Companion.toMediaTypeOrNull
import okhttp3.ResponseBody.Companion.toResponseBody
import org.junit.After
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.mockito.MockitoAnnotations
import retrofit2.Response

class GetUsersServiceTest {

    // Mock the GetUsersApiClient
    @Mock
    private lateinit var mockApiClient: GetUsersApiClient

    // Class under test
    private lateinit var service: GetUsersService

    private val testDispatcher = UnconfinedTestDispatcher()

    @Before
    fun setUp() {
        // Initialize Mockito annotations
        MockitoAnnotations.openMocks(this)

        // Initialize the service with the mock client
        service = GetUsersService(mockApiClient)

        // Set the main dispatcher for testing
        Dispatchers.setMain(testDispatcher)
    }

    @After
    fun tearDown() {
        // Reset the main dispatcher after testing
        Dispatchers.resetMain()
    }

    @Test
    fun getUsers_SuccessfulResponse() = runBlocking {
        // Mock successful response
        val userInfo = UserInfo(/* Populate with test data */)
        val response = Response.success(userInfo)
        `when`(mockApiClient.getUsersApiClient(numUsers = 10)).thenReturn(response)

        // Call the method under test
        val result = service.getUsers(numUsers = 10)

        // Verify the result
        assertEquals(response, result)
    }

    @Test
    fun getUsers_FailureResponse() = runBlocking {
        // Mock failure response
        val errorMessage = "Error message"
    }
}