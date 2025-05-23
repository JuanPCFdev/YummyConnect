package com.jpdev.yummyconnect.domain.model

data class Recipe(
    val id: String = "",     // Automatically generated if new
    val userId: String,      // Creator user ID
    val title: String,
    val description: String,
    val preparationTime: Int, // In minutes
    val servings: Int,
    val difficulty: RecipeDifficulty = RecipeDifficulty.MEDIUM,
    val isVegetarian: Boolean = false,
    val tags: Set<String> = emptySet() // Example: #desserts, #vegan
) {
    enum class RecipeDifficulty { EASY, MEDIUM, HARD }
}
