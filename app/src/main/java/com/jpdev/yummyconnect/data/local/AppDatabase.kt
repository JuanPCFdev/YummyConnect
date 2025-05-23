package com.jpdev.yummyconnect.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.jpdev.yummyconnect.data.local.dao.CommentDao
import com.jpdev.yummyconnect.data.local.dao.PostDao
import com.jpdev.yummyconnect.data.local.dao.RecipeDao
import com.jpdev.yummyconnect.data.local.dao.UserDao
import com.jpdev.yummyconnect.data.local.entity.CommentEntity
import com.jpdev.yummyconnect.data.local.entity.IngredientEntity
import com.jpdev.yummyconnect.data.local.entity.PostEntity
import com.jpdev.yummyconnect.data.local.entity.RecipeEntity
import com.jpdev.yummyconnect.data.local.entity.RecipeStepEntity
import com.jpdev.yummyconnect.data.local.entity.UserEntity

@Database(
    entities = [
        UserEntity::class,
        RecipeEntity::class,
        RecipeStepEntity::class,
        IngredientEntity::class,
        PostEntity::class,
        CommentEntity::class
    ],
    version = 1,
    exportSchema = false
)

abstract class AppDatabase: RoomDatabase(){
    abstract fun userDao(): UserDao
    abstract fun recipeDao(): RecipeDao
    abstract fun postDao(): PostDao
    abstract fun commentDao(): CommentDao
}