package com.jpdev.yummyconnect.domain.usecase.user

import com.jpdev.yummyconnect.domain.model.User
import com.jpdev.yummyconnect.domain.repository.UserRepository
import com.jpdev.yummyconnect.domain.usecase.GetUserByIdUseCase
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Test
import org.mockito.kotlin.mock
import org.mockito.kotlin.verify
import org.mockito.kotlin.whenever

@OptIn(ExperimentalCoroutinesApi::class)
class GetUserByIdUseCaseTest {

    private val mockUserRepo: UserRepository = mock()
    private lateinit var getUserByIdUseCase: GetUserByIdUseCase

    @Before
    fun setUp() {
        getUserByIdUseCase = GetUserByIdUseCase(mockUserRepo)
    }

    @Test
    fun `invoke should return User when repository returns User`() = runBlocking {
        val user = User(id = "u6", name = "María", email = "m@m.com", recipes = emptyList())
        whenever(mockUserRepo.getUserById("u6")).thenReturn(user)

        val result = getUserByIdUseCase("u6")
        verify(mockUserRepo).getUserById("u6")
        assert(result == user)
    }

    @Test
    fun `invoke should return null when repository returns null`() = runBlocking {
        whenever(mockUserRepo.getUserById("nope")).thenReturn(null)

        val result = getUserByIdUseCase("nope")
        verify(mockUserRepo).getUserById("nope")
        assert(result == null)
    }

}