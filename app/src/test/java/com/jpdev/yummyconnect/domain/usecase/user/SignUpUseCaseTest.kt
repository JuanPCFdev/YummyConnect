package com.jpdev.yummyconnect.domain.usecase.user

import com.jpdev.yummyconnect.domain.model.User
import com.jpdev.yummyconnect.domain.repository.AuthRepository
import com.jpdev.yummyconnect.domain.usecase.auth.SignUpUseCase
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Test
import org.mockito.kotlin.mock
import org.mockito.kotlin.verify
import org.mockito.kotlin.whenever

@OptIn(ExperimentalCoroutinesApi::class)
class SignUpUseCaseTest {

    private val mockAuthRepo: AuthRepository = mock()
    private lateinit var signUpUseCase: SignUpUseCase

    @Before
    fun setUp() {
        signUpUseCase = SignUpUseCase(mockAuthRepo)
    }

    @Test
    fun `invoke should return User when repository returns User`() = runBlocking {
        val dummyUser = User(id = "u2", name = "Jhon Doe", email = "j@j.com", recipes = emptyList())
        whenever(mockAuthRepo.signUp("j@j.com", "pass")).thenReturn(dummyUser)

        val result = signUpUseCase("j@j.com", "pass")


        verify(mockAuthRepo).signUp("j@j.com", "pass")
        assert(dummyUser == result)
    }

    @Test
    fun `invoke should return null when repository returns null`() = runBlocking {
        whenever(mockAuthRepo.signUp("no@user.com", "bad")).thenReturn(null)

        val result = signUpUseCase("no@user.com", "bad")
        verify(mockAuthRepo).signUp("no@user.com", "bad")
        assert(result == null)
    }

}