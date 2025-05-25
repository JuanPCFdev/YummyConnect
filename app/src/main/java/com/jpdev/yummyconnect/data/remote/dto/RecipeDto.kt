package com.jpdev.yummyconnect.data.remote.dto

data class RecipeDTO(
    val id: String = "",
    val userId: String = "",
    val title: String = "",
    val description: String = "",
    val preparationTime: Int = 0,
    val servings: Int = 0,
    val difficulty: String = "EASY",
    val isVegetarian: Boolean = false,
    val ingredients: List<IngredientDto> = emptyList(),
    val steps: List<String> = emptyList(),
    val createdAt: Long = 0
)