package com.jpdev.yummyconnect.domain.usecase.recipe

import com.jpdev.yummyconnect.domain.model.Recipe
import com.jpdev.yummyconnect.domain.repository.RecipeRepository
import com.jpdev.yummyconnect.domain.usecase.GetRecipesByUserUseCase
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Test
import org.mockito.kotlin.mock
import org.mockito.kotlin.verify
import org.mockito.kotlin.whenever


@OptIn(ExperimentalCoroutinesApi::class)
class GetRecipesByUserUseCaseTest {
    private val mockRecipeRepo: RecipeRepository = mock()
    private lateinit var getRecipesByUserUseCase: GetRecipesByUserUseCase

    @Before
    fun setUp() {
        getRecipesByUserUseCase = GetRecipesByUserUseCase(mockRecipeRepo)
    }

    @Test
    fun `invoke should return list of recipes when repository returns list`() = runBlocking {
        val r1 = Recipe(
            id = "r1",
            userId = "uX",
            title = "Sopa",
            description = "...",
            preparationTime = 10,
            servings = 2,
            difficulty = "Easy",
            isVegetarian = false,
            ingredients = emptyList(),
            steps = emptyList()
        )
        val r2 = Recipe(
            id = "r2",
            userId = "uX",
            title = "Guacamole",
            description = "...",
            preparationTime = 5,
            servings = 1,
            difficulty = "Easy",
            isVegetarian = true,
            ingredients = emptyList(),
            steps = emptyList()
        )
        whenever(mockRecipeRepo.getRecipesByUserId("uX")).thenReturn(listOf(r1, r2))

        val result = getRecipesByUserUseCase("uX")
        verify(mockRecipeRepo).getRecipesByUserId("uX")
        assert(result.size == 2)
        assert(result[0].title == "Sopa")
    }

}