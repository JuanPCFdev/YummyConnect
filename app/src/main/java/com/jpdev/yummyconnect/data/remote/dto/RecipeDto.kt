package com.jpdev.yummyconnect.data.remote.dto

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class RecipeDto(
    val id: String = "",
    val userId: String = "",
    val title: String = "",
    val description: String = "",
    val preparationTime: Int = 0,
    val servings: Int = 0,
    val difficulty: String = "MEDIUM",
    val isVegetarian: Boolean = false,
    val tags: List<String> = emptyList()
) : Parcelable