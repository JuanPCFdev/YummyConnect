package com.jpdev.yummyconnect.domain.model

data class Recipe(
    val id: String = "",     // Automatically generated if new
    val userId: String,      // Creator user ID
    val title: String,
    val description: String,
    val preparationTime: Int, // In minutes
    val servings: Int,
    val difficulty: String, //Easy, Medium, Hard
    val isVegetarian: Boolean = false,
    val ingredients:List<Ingredient>,
    val steps:List<String>
)
