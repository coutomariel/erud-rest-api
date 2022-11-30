package br.com.coutomariel.restwithspringbootandkotlin.dto.request

import br.com.coutomariel.restwithspringbootandkotlin.model.Gender


data class CreatePersonDTO(
    var firstName: String? = null,
    var lastName: String? = null,
    var adress: String? = null,
    var gender: Gender? = null,
)