package io.github.deepanshut041.swadhyay.services

import io.github.deepanshut041.swadhyay.data.entity.ModuleProgressEntity
import io.github.deepanshut041.swadhyay.data.repository.ModuleProgressRepository
import org.springframework.data.mongodb.repository.ReactiveMongoRepository
import org.springframework.stereotype.Repository
import org.springframework.stereotype.Service

@Service("moduleProgressService")
class ModuleProgressServiceImpl(
        private val moduleProgressRepository: ModuleProgressRepository
): ModuleProgressService {


}

interface ModuleProgressService {

}