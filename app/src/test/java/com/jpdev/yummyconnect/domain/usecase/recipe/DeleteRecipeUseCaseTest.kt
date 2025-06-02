package com.jpdev.yummyconnect.domain.usecase.recipe

import com.jpdev.yummyconnect.domain.repository.RecipeRepository
import com.jpdev.yummyconnect.domain.usecase.recipe.DeleteRecipeUseCase
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Test
import org.mockito.kotlin.mock
import org.mockito.kotlin.verify

@OptIn(ExperimentalCoroutinesApi::class)
class DeleteRecipeUseCaseTest {
    private val mockRecipeRepo: RecipeRepository = mock()
    private lateinit var deleteRecipeUseCase: DeleteRecipeUseCase

    @Before
    fun setUp() {
        deleteRecipeUseCase = DeleteRecipeUseCase(mockRecipeRepo)
    }

    @Test
    fun `invoke should call repository deleteRecipe with given id`() = runBlocking {
        deleteRecipeUseCase("rX99")
        verify(mockRecipeRepo).deleteRecipe("rX99")
    }
}