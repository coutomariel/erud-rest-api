package br.com.coutomariel.restwithspringbootandkotlin.model

import javax.persistence.*

@Entity
data class Person(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null,
    var firstName: String? = "",
    var lastName: String? = "",
    var adress: String? = "",
    @Enumerated(EnumType.STRING)
    var gender: Gender? = null

    )