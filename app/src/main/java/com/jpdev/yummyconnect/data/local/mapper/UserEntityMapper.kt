package com.jpdev.yummyconnect.data.local.mapper

import com.jpdev.yummyconnect.data.local.entity.UserEntity
import com.jpdev.yummyconnect.domain.model.User

fun UserEntity.toDomain() = User(id, name, email, profileImage)
fun User.toEntity() = UserEntity(id, name, email, profileImage)