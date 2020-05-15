package io.github.deepanshut041.swadhyay.data.repository

import io.github.deepanshut041.swadhyay.data.entity.ModuleProgressEntity
import org.springframework.data.mongodb.repository.ReactiveMongoRepository
import org.springframework.stereotype.Repository

@Repository
interface ModuleProgressRepository: ReactiveMongoRepository<ModuleProgressEntity, String> {
}