package com.jpdev.yummyconnect.data.mapper

import com.jpdev.yummyconnect.data.dto.PostDto
import com.jpdev.yummyconnect.data.dto.toDomain
import com.jpdev.yummyconnect.data.dto.toDto
import com.jpdev.yummyconnect.domain.model.Post
import org.junit.Test
import org.junit.Assert.assertEquals

class PostDtoMapperTest {
    @Test
    fun `toDomain should map fields and convert likes list to set`() {
        val dto = PostDto(
            id = "pX",
            userId = "uX",
            recipeId = "rX",
            image = "urlX",
            timestamp = 999L,
            likes = listOf("u1", "u2")
        )

        val domain: Post = dto.toDomain()

        assertEquals("pX", domain.id)
        assertEquals("uX", domain.userId)
        assertEquals("rX", domain.recipeId)
        assertEquals("urlX", domain.image)
        assertEquals(999L, domain.timestamp)
        assert(domain.likes.contains("u2"))
        assertEquals(2, domain.likes.size)
    }

    @Test
    fun `toDto should map fields and convert likes set to list`() {
        val domain = Post(
            id = "pY",
            userId = "uY",
            recipeId = "rY",
            image = "urlY",
            timestamp = 1000L,
            likes = setOf("u3", "u4")
        )

        val dto: PostDto = domain.toDto()

        assertEquals("pY", dto.id)
        assertEquals("uY", dto.userId)
        assertEquals("rY", dto.recipeId)
        assertEquals("urlY", dto.image)
        assertEquals(1000L, dto.timestamp)
        assertEquals(2, dto.likes.size)
        assert(dto.likes.contains("u3"))
    }
}