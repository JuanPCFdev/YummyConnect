package com.jpdev.yummyconnect.data.remote.mapper

import com.jpdev.yummyconnect.data.local.entity.UserEntity
import com.jpdev.yummyconnect.data.remote.dto.UserDto
import com.jpdev.yummyconnect.domain.model.User

fun UserDto.toDomain() = User(id, name, email, profileImage)
fun User.toDto() = UserDto(id, name, email, profileImage)
fun UserDto.toEntity() = UserEntity(id, name, email, profileImage)
fun UserEntity.toDto() = UserDto(id = id, name = name, email = email, profileImage = profileImage)