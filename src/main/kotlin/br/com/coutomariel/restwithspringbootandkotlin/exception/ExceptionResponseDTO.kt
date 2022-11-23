package br.com.coutomariel.restwithspringbootandkotlin.exception

import java.time.LocalDateTime

class ExceptionResponseDTO (
    val timestamp: LocalDateTime? = LocalDateTime.now(),
    val message: String?,
    val details: String,
    )