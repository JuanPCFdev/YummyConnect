package com.jpdev.yummyconnect.data.mapper

import com.jpdev.yummyconnect.data.dto.CommentDto
import com.jpdev.yummyconnect.data.dto.toDomain
import com.jpdev.yummyconnect.data.dto.toDto
import com.jpdev.yummyconnect.domain.model.Comment
import org.junit.Test
import org.junit.Assert.assertEquals

class CommentDtoMapperTest {
    @Test
    fun `toDomain should map all fields`() {
        val dto = CommentDto(
            id = "cX",
            postId = "pX",
            userId = "uX",
            text = "Hola",
            timestamp = 555L
        )

        val domain: Comment = dto.toDomain()

        assertEquals("cX", domain.id)
        assertEquals("pX", domain.postId)
        assertEquals("uX", domain.userId)
        assertEquals("Hola", domain.text)
        assertEquals(555L, domain.timestamp)
    }

    @Test
    fun `toDto should map all fields`() {
        val domain = Comment(
            id = "cY",
            postId = "pY",
            userId = "uY",
            text = "Mundo",
            timestamp = 777L
        )

        val dto: CommentDto = domain.toDto()

        assertEquals("cY", dto.id)
        assertEquals("pY", dto.postId)
        assertEquals("uY", dto.userId)
        assertEquals("Mundo", dto.text)
        assertEquals(777L, dto.timestamp)
    }
}