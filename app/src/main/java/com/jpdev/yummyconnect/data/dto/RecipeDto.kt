package com.jpdev.yummyconnect.data.dto

import com.jpdev.yummyconnect.domain.model.Recipe

data class RecipeDto(
    val id: String = "",
    val userId: String = "",
    val title: String = "",
    val description: String = "",
    val preparationTime: Int = 0,
    val servings: Int = 0,
    val difficulty: String = "",
    val isVegetarian: Boolean = false,
    val ingredients: List<IngredientDto> = emptyList<IngredientDto>(),
    val steps: List<String> = emptyList()
)

fun RecipeDto.toDomain(): Recipe = Recipe(
    id = this.id,
    userId = this.userId,
    title = this.title,
    description = this.description,
    preparationTime = this.preparationTime,
    servings = this.servings,
    difficulty = this.difficulty,
    isVegetarian = this.isVegetarian,
    ingredients = this.ingredients.map { it.toDomain() },
    steps = this.steps.toList()
)

fun Recipe.toDto(): RecipeDto = RecipeDto(
    id = this.id,
    userId = this.userId,
    title = this.title,
    description = this.description,
    preparationTime = this.preparationTime,
    servings = this.servings,
    difficulty = this.difficulty,
    isVegetarian = this.isVegetarian,
    ingredients = this.ingredients.map { it.toDto() },
    steps = this.steps.toList()
)