package br.com.coutomariel.restwithspringbootandkotlin.service

import br.com.coutomariel.restwithspringbootandkotlin.exception.PersonNotFoundExeption
import br.com.coutomariel.restwithspringbootandkotlin.model.Person
import br.com.coutomariel.restwithspringbootandkotlin.repository.PersonRepository
import org.springframework.stereotype.Service

@Service
class PersonService(
    private val personRepository: PersonRepository,
) {

    fun createPerson(person: Person): Person {
        return personRepository.save(person)
    }

    fun findById(id: Long): Person {
        return personRepository.findById(id)
            .orElseThrow { PersonNotFoundExeption("Person not found with ID:$id") }
    }

    fun getAll(): List<Person> {
        return personRepository.findAll()
    }

    fun updatePerson(id: Long, person: Person): Person {
        val update = findById(id)
            .copy(
                firstName = person.firstName,
                lastName = person.lastName,
                adress = person.adress,
                gender = person.gender
            )
        return personRepository.save(update)
    }

    fun delete(id: Long) {
        findById(id).also { personRepository.delete(it) }
    }

}