import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
	id("org.springframework.boot") version "2.3.0.RELEASE"
	id("io.spring.dependency-management") version "1.0.9.RELEASE"
	kotlin("jvm") version "1.3.72"
	kotlin("plugin.spring") version "1.3.72"
}

group = "io.github.deepanshut041"
version = "0.0.1"
java.sourceCompatibility = JavaVersion.VERSION_11

repositories {
	mavenCentral()
}

dependencies {

	// Reactor
	implementation("org.springframework.boot:spring-boot-starter-webflux")

	// Kotlin
	implementation("org.jetbrains.kotlin:kotlin-reflect")
	implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")
	implementation("com.fasterxml.jackson.module:jackson-module-kotlin")

	// Kotlin reactor
	implementation("io.projectreactor.kotlin:reactor-kotlin-extensions")
	implementation("org.jetbrains.kotlinx:kotlinx-coroutines-reactor")

	// Security
	implementation("org.springframework.boot:spring-boot-starter-security")

	// Data
	implementation("org.springframework.boot:spring-boot-starter-data-mongodb-reactive")

	// JWT
	implementation("io.jsonwebtoken:jjwt-api:0.10.7")
	implementation("io.jsonwebtoken:jjwt-jackson:0.10.7")
	runtimeOnly("io.jsonwebtoken:jjwt-impl:0.10.7")

	// OpenAP
	implementation("org.springdoc:springdoc-openapi-webflux-ui:1.3.9")
	implementation("org.springdoc:springdoc-openapi-security:1.3.9")
	implementation("org.springdoc:springdoc-openapi-kotlin:1.3.9")

	// Logger
	implementation("io.github.microutils:kotlin-logging:1.7.9")

	// Testing
	testImplementation("org.springframework.boot:spring-boot-starter-test") {
		exclude(group = "org.junit.vintage", module = "junit-vintage-engine")
	}
	testImplementation("io.projectreactor:reactor-test")
	testImplementation("org.springframework.security:spring-security-test")
}

tasks.withType<Test> {
	useJUnitPlatform()
}

tasks.withType<KotlinCompile> {
	kotlinOptions {
		freeCompilerArgs = listOf("-Xjsr305=strict")
		jvmTarget = "11"
	}
}
