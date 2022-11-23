package br.com.coutomariel.restwithspringbootandkotlin.exception

import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler

@RestController
@ControllerAdvice
class ExceptionHandlerController : ResponseEntityExceptionHandler(){

    @ExceptionHandler(value = [Exception::class])
    fun handleAllExceptions(exception: Exception): ResponseEntity<ExceptionResponseDTO> {
        val response = ExceptionResponseDTO(
            message = exception.message,
            details = "Error unexpected"
        )
        return ResponseEntity(response, HttpStatus.INTERNAL_SERVER_ERROR)
    }

    @ExceptionHandler(value = [PersonNotFoundExeption::class])
    fun handlePersonNotFoundException(exception: PersonNotFoundExeption): ResponseEntity<ExceptionResponseDTO> {
        val response = ExceptionResponseDTO(
            message = exception.message,
            details = "Error unexpected"
        )
        return ResponseEntity(response, HttpStatus.NOT_FOUND)
    }

}