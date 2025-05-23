package com.jpdev.yummyconnect.data.local.mapper

import com.jpdev.yummyconnect.data.local.entity.IngredientEntity
import com.jpdev.yummyconnect.data.local.entity.RecipeEntity
import com.jpdev.yummyconnect.data.local.entity.RecipeStepEntity
import com.jpdev.yummyconnect.domain.model.Ingredient
import com.jpdev.yummyconnect.domain.model.Recipe
import com.jpdev.yummyconnect.domain.model.RecipeStep

fun RecipeEntity.toDomain(steps: List<RecipeStep>, ingredients: List<Ingredient>) = Recipe(
    id = id,
    userId = userId,
    title = title,
    description = description,
    preparationTime = preparationTime,
    servings = servings,
    difficulty = Recipe.RecipeDifficulty.valueOf(difficulty),
    isVegetarian = isVegetarian,
    tags = emptySet() // manejar tags aparte
)
fun Recipe.toEntity() = RecipeEntity(
    id = this.id,
    userId = this.userId,
    title = this.title,
    description = this.description,
    preparationTime = this.preparationTime,
    servings = this.servings,
    difficulty = this.difficulty.name,
    isVegetarian = this.isVegetarian
)

fun RecipeStepEntity.toDomain() = RecipeStep(description, stepOrder)
fun RecipeStep.toEntity(recipeId: String) = RecipeStepEntity(
    recipeId = recipeId,
    description = description,
    stepOrder = order
)

fun IngredientEntity.toDomain() = Ingredient(name, quantity)
fun Ingredient.toEntity(recipeId: String) = IngredientEntity(
    recipeId = recipeId,
    name = name,
    quantity = quantity
)