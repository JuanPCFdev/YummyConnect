package com.jpdev.yummyconnect.data.remote.dto

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class UserDto(
    val id: String = "",
    val name: String = "",
    val email: String = "",
    val profileImage: String? = null
) : Parcelable