package br.com.coutomariel.restwithspringbootandkotlin.dto.response

import br.com.coutomariel.restwithspringbootandkotlin.model.Gender


data class PersonDTO(
    var id: Long? = 0,
    var firstName: String? = null,
    var lastName: String? = null,
    var adress: String? = null,
    var gender: Gender? = null,
)