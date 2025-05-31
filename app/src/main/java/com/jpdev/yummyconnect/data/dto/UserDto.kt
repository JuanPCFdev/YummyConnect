package com.jpdev.yummyconnect.data.dto

import com.jpdev.yummyconnect.domain.model.User

data class UserDto(
    val id: String = "",
    val name: String = "",
    val email: String = "",
    val recipes: List<RecipeDto> = emptyList<RecipeDto>(),
)

fun UserDto.toDomain(): User = User(
    id = this.id,
    name = this.name,
    email = this.email,
    recipes = this.recipes.map { it.toDomain() }
)

fun User.toDto(): UserDto = UserDto(
    id = this.id,
    name = this.name,
    email = this.email,
    recipes = this.recipes.map { it.toDto() }
)