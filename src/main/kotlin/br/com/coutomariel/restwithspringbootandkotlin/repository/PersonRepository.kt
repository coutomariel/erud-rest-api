package br.com.coutomariel.restwithspringbootandkotlin.repository

import br.com.coutomariel.restwithspringbootandkotlin.model.Person
import org.springframework.data.jpa.repository.JpaRepository

interface PersonRepository: JpaRepository<Person, Long>{
}
