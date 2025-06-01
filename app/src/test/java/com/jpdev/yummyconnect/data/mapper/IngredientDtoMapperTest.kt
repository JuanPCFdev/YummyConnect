package com.jpdev.yummyconnect.data.mapper

import com.jpdev.yummyconnect.data.dto.IngredientDto
import com.jpdev.yummyconnect.data.dto.toDomain
import com.jpdev.yummyconnect.data.dto.toDto
import com.jpdev.yummyconnect.domain.model.Ingredient
import org.junit.Test
import org.junit.Assert.assertEquals

class IngredientDtoMapperTest {

    @Test
    fun `toDomain should map fields correctly`() {
        val dto = IngredientDto(name = "Tomate", quantity = "2 uds")
        val domain: Ingredient = dto.toDomain()

        assertEquals("Tomate", domain.name)
        assertEquals("2 uds", domain.quantity)
    }

    @Test
    fun `toDto should map fields correctly`() {
        val domain = Ingredient(name = "Cilantro", quantity = "10g")
        val dto: IngredientDto = domain.toDto()

        assertEquals("Cilantro", dto.name)
        assertEquals("10g", dto.quantity)
    }

}