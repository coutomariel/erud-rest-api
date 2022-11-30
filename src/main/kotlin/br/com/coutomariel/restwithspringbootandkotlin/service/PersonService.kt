package br.com.coutomariel.restwithspringbootandkotlin.service

import br.com.coutomariel.restwithspringbootandkotlin.dto.DozerParser
import br.com.coutomariel.restwithspringbootandkotlin.dto.request.CreatePersonDTO
import br.com.coutomariel.restwithspringbootandkotlin.dto.response.PersonDTO
import br.com.coutomariel.restwithspringbootandkotlin.exception.PersonNotFoundExeption
import br.com.coutomariel.restwithspringbootandkotlin.model.Person
import br.com.coutomariel.restwithspringbootandkotlin.repository.PersonRepository
import org.springframework.stereotype.Service

@Service
class PersonService(
    private val personRepository: PersonRepository,
) {

    fun createPerson(personDTO: CreatePersonDTO): PersonDTO {
        val person = DozerParser.parseObject(personDTO, Person::class.java)
        val savedPerson = personRepository.save(person)
        return DozerParser.parseObject(savedPerson, PersonDTO::class.java)
    }

    fun findById(id: Long): Person {
        return personRepository.findById(id)
            .orElseThrow { PersonNotFoundExeption("Person not found with ID:$id") }
    }

    fun getById(id: Long): PersonDTO {
        val person = findById(id)
        return DozerParser.parseObject(person, PersonDTO::class.java)
    }

    fun getAll(): List<PersonDTO> {
        return personRepository.findAll()
            .map { p -> DozerParser.parseObject(p, PersonDTO::class.java) }
    }

    fun updatePerson(id: Long, person: Person): PersonDTO {
        val update = findById(id)
            .copy(
                firstName = person.firstName,
                lastName = person.lastName,
                adress = person.adress,
                gender = person.gender
            )
        val updatedPerson = personRepository.save(update)
        return DozerParser.parseObject(updatedPerson, PersonDTO::class.java)
    }

    fun delete(id: Long) {
        findById(id).also { personRepository.delete(it) }
    }

}