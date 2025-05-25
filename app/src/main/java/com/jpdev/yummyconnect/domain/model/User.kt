package com.jpdev.yummyconnect.domain.model

data class User(
    val id: String,          // Unique ID from Firebase Auth
    val name: String,
    val email: String,
    val recipes: List<Recipe>
)