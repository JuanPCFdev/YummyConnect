package com.jpdev.yummyconnect.data.dto

import com.jpdev.yummyconnect.domain.model.Ingredient

data class IngredientDto(
    val name: String = "",
    val quantity: String = "",
)

fun IngredientDto.toDomain(): Ingredient = Ingredient(
    name = this.name,
    quantity = this.quantity
)

fun Ingredient.toDto(): IngredientDto = IngredientDto(
    name = this.name,
    quantity = this.quantity
)