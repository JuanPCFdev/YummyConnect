package com.jpdev.yummyconnect.data.mapper

import com.jpdev.yummyconnect.data.dto.IngredientDto
import com.jpdev.yummyconnect.data.dto.RecipeDto
import com.jpdev.yummyconnect.data.dto.toDomain
import com.jpdev.yummyconnect.data.dto.toDto
import com.jpdev.yummyconnect.domain.model.Ingredient
import com.jpdev.yummyconnect.domain.model.Recipe
import org.junit.Test
import org.junit.Assert.assertEquals

class RecipeDtoMapperTest {

    @Test
    fun `toDomain should map all fields from RecipeDto to Recipe`() {
        val dto = RecipeDto(
            id = "r100",
            userId = "u100",
            title = "Panqueques",
            description = "Ricos",
            preparationTime = 20,
            servings = 3,
            difficulty = "Easy",
            isVegetarian = true,
            ingredients = listOf(IngredientDto(name = "Harina", quantity = "200g")),
            steps = listOf("Mezclar", "Cocinar")
        )

        val domain: Recipe = dto.toDomain()

        assertEquals("r100", domain.id)
        assertEquals("u100", domain.userId)
        assertEquals("Panqueques", domain.title)
        assertEquals("Ricos", domain.description)
        assertEquals(20, domain.preparationTime)
        assertEquals(3, domain.servings)
        assertEquals("Easy", domain.difficulty)
        assertEquals(true, domain.isVegetarian)
        assertEquals(1, domain.ingredients.size)
        assertEquals("Harina", domain.ingredients[0].name)
        assertEquals("Cocinar", domain.steps.last())
    }

    @Test
    fun `toDto should map all fields from Recipe to RecipeDto`() {
        val domain = Recipe(
            id = "r200",
            userId = "u200",
            title = "Ensalada",
            description = "Verde",
            preparationTime = 10,
            servings = 2,
            difficulty = "Medium",
            isVegetarian = true,
            ingredients = listOf(Ingredient(name = "Lechuga", quantity = "100g")),
            steps = listOf("Lavar", "Servir")
        )

        val dto: RecipeDto = domain.toDto()

        assertEquals("r200", dto.id)
        assertEquals("u200", dto.userId)
        assertEquals("Ensalada", dto.title)
        assertEquals("Verde", dto.description)
        assertEquals(10, dto.preparationTime)
        assertEquals(2, dto.servings)
        assertEquals("Medium", dto.difficulty)
        assertEquals(true, dto.isVegetarian)
        assertEquals(1, dto.ingredients.size)
        assertEquals("Lechuga", dto.ingredients[0].name)
        assertEquals("Servir", dto.steps.last())
    }

}