package com.jpdev.yummyconnect.domain.usecase.recipe

import com.jpdev.yummyconnect.domain.model.Recipe
import com.jpdev.yummyconnect.domain.repository.RecipeRepository
import com.jpdev.yummyconnect.domain.usecase.recipe.AddRecipeUseCase
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Test
import org.mockito.kotlin.mock
import org.mockito.kotlin.verify

@OptIn(ExperimentalCoroutinesApi::class)
class AddRecipeUseCaseTest {

    private val mockRecipeRepo: RecipeRepository = mock()
    private lateinit var addRecipeUseCase: AddRecipeUseCase

    @Before
    fun setUp() {
        addRecipeUseCase = AddRecipeUseCase(mockRecipeRepo)
    }

    @Test
    fun `invoke should call repository addRecipe with same recipe`() = runBlocking {
        val recipe = Recipe(
            id = "r10",
            userId = "u10",
            title = "Pan",
            description = "Casero",
            preparationTime = 30,
            servings = 4,
            difficulty = "Medium",
            isVegetarian = false,
            ingredients = emptyList(),
            steps = emptyList()
        )

        addRecipeUseCase(recipe)

        verify(mockRecipeRepo).addRecipe(recipe)
    }

}