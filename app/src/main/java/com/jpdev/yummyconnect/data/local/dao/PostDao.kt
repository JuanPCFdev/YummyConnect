package com.jpdev.yummyconnect.data.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.jpdev.yummyconnect.data.local.entity.PostEntity

@Dao
interface PostDao {
    @Query("SELECT * FROM posts WHERE recipeId = :recipeId")
    suspend fun getPostsForRecipe(recipeId: String): List<PostEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertPost(post: PostEntity)
}