package io.github.deepanshut041.swadhyay.web.controller

import io.github.deepanshut041.swadhyay.util.BadRequestException
import io.github.deepanshut041.swadhyay.util.ResourceNotFoundException
import io.github.deepanshut041.swadhyay.util.UnauthorizedException
import io.github.deepanshut041.swadhyay.web.dto.APIResponse
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.MethodArgumentNotValidException
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestControllerAdvice
import javax.validation.ConstraintViolationException
import javax.validation.ValidationException


@RestControllerAdvice
class ExceptionTranslator {

    @ExceptionHandler(UnauthorizedException::class)
    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    fun unauthorizedException(ex: UnauthorizedException): ResponseEntity<APIResponse> {
        return ResponseEntity(APIResponse(ex.message ?: ""), HttpStatus.UNAUTHORIZED)
    }

    @ExceptionHandler(ResourceNotFoundException::class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    fun notFoundException(ex: ResourceNotFoundException): ResponseEntity<APIResponse> {
        return ResponseEntity(APIResponse(ex.message ?: ""), HttpStatus.NOT_FOUND)
    }

    @ExceptionHandler(BadRequestException::class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    fun badRequestException(ex: BadRequestException): ResponseEntity<APIResponse>? {
        return ResponseEntity(APIResponse(ex.message ?: ""), HttpStatus.BAD_REQUEST)
    }

    @ExceptionHandler(MethodArgumentNotValidException::class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    fun constraintValidationException(ex: MethodArgumentNotValidException): ResponseEntity<APIResponse> {
        val exceptionResponse = String.format("Invalid input parameters: %s\n", ex.message)
        return ResponseEntity(APIResponse(exceptionResponse), HttpStatus.BAD_REQUEST)
    }
}