package com.jpdev.yummyconnect.data.remote.dto

data class UserDto(
    val id: String = "",
    val name: String = "",
    val email: String = "",
    val recipeIds: List<String> = emptyList()
)