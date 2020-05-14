package io.github.deepanshut041.swadhyay

import io.github.deepanshut041.swadhyay.config.AppProperties
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.context.properties.EnableConfigurationProperties
import org.springframework.boot.runApplication
import org.springframework.data.mongodb.repository.config.EnableReactiveMongoRepositories

@SpringBootApplication
@EnableConfigurationProperties(AppProperties::class)
@EnableReactiveMongoRepositories
class SwadhyayApplication

fun main(args: Array<String>) {
	runApplication<SwadhyayApplication>(*args)
}
