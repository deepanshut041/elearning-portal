package io.github.deepanshut041.swadhyay.data.entity

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.index.Indexed
import org.springframework.data.mongodb.core.mapping.Document
import java.util.*

@Document("users")
data class UserEntity (
        @Id val id: String?,
        @Indexed(unique = true) val email: String,
        val password: String,
        val name: String,
        val avatar: String,
        val about: String,
        val active: Boolean,
        val roles: List<String>,
        val created: Date,
        val updated: Date
)

