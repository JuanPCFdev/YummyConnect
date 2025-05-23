package com.jpdev.yummyconnect.data.remote.mapper

import com.jpdev.yummyconnect.data.local.entity.RecipeEntity
import com.jpdev.yummyconnect.data.remote.dto.RecipeDto
import com.jpdev.yummyconnect.domain.model.Recipe

fun RecipeDto.toDomain() = Recipe(
    id = id,
    userId = userId,
    title = title,
    description = description,
    preparationTime = preparationTime,
    servings = servings,
    difficulty = Recipe.RecipeDifficulty.valueOf(difficulty),
    isVegetarian = isVegetarian,
    tags = tags.toSet()
)
fun Recipe.toDto() = RecipeDto(
    id = id,
    userId = userId,
    title = title,
    description = description,
    preparationTime = preparationTime,
    servings = servings,
    difficulty = difficulty.name,
    isVegetarian = isVegetarian,
    tags = tags.toList()
)
fun RecipeDto.toEntity() = RecipeEntity(
    id = id,
    userId = userId,
    title = title,
    description = description,
    preparationTime = preparationTime,
    servings = servings,
    difficulty = difficulty,
    isVegetarian = isVegetarian
)
fun RecipeEntity.toDto() = RecipeDto(
    id = id,
    userId = userId,
    title = title,
    description = description,
    preparationTime = preparationTime,
    servings = servings,
    difficulty = difficulty,
    isVegetarian = isVegetarian
)