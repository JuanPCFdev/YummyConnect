package com.jpdev.yummyconnect.data.mapper

import com.jpdev.yummyconnect.data.dto.RecipeDto
import com.jpdev.yummyconnect.data.dto.UserDto
import com.jpdev.yummyconnect.data.dto.toDomain
import com.jpdev.yummyconnect.data.dto.toDto
import com.jpdev.yummyconnect.domain.model.Recipe
import com.jpdev.yummyconnect.domain.model.User
import org.junit.Test
import org.junit.Assert.assertEquals

class UserDtoMapperTest {

    @Test
    fun `toDomain should map fields and recipes list`() {
        // Creamos un RecipeDto dentro de la lista
        val recipeDto = RecipeDto(
            id = "rX",
            userId = "uX",
            title = "X",
            description = "desc",
            preparationTime = 5,
            servings = 1,
            difficulty = "Easy",
            isVegetarian = false,
            ingredients = emptyList(),
            steps = emptyList()
        )
        val dto = UserDto(
            id = "uX",
            name = "UserX",
            email = "ux@ux.com",
            recipes = listOf(recipeDto)
        )

        val domain: User = dto.toDomain()

        assertEquals("uX", domain.id)
        assertEquals("UserX", domain.name)
        assertEquals("ux@ux.com", domain.email)
        assertEquals(1, domain.recipes.size)
        assertEquals("X", domain.recipes[0].title)
    }

    @Test
    fun `toDto should map fields and recipes list`() {
        val recipe = Recipe(
            id = "rY",
            userId = "uY",
            title = "Y",
            description = "descY",
            preparationTime = 7,
            servings = 2,
            difficulty = "Medium",
            isVegetarian = true,
            ingredients = emptyList(),
            steps = emptyList()
        )
        val domain = User(
            id = "uY",
            name = "UserY",
            email = "uy@uy.com",
            recipes = listOf(recipe)
        )

        val dto: UserDto = domain.toDto()

        assertEquals("uY", dto.id)
        assertEquals("UserY", dto.name)
        assertEquals("uy@uy.com", dto.email)
        assertEquals(1, dto.recipes.size)
        assertEquals("Y", dto.recipes[0].title)
    }

}