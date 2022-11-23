package br.com.coutomariel.restwithspringbootandkotlin.model

import javax.persistence.*

@Entity
data class Person(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,
    val firstName: String? = null,
    val lastName: String? = null,
    val adress: String? = null,
    @Enumerated(EnumType.STRING)
    val gender: Gender? = null

    )