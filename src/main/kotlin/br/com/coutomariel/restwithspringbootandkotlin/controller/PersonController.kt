package br.com.coutomariel.restwithspringbootandkotlin.controller

import br.com.coutomariel.restwithspringbootandkotlin.dto.request.CreatePersonDTO
import br.com.coutomariel.restwithspringbootandkotlin.dto.response.PersonDTO
import br.com.coutomariel.restwithspringbootandkotlin.model.Person
import br.com.coutomariel.restwithspringbootandkotlin.service.PersonService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/person")
class PersonController {

    @Autowired
    private lateinit var personService: PersonService

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    fun getPerson(@RequestBody person: CreatePersonDTO): PersonDTO {
        return personService.createPerson(person)
    }

    @GetMapping("/{id}")
    fun getById(@PathVariable id: Long): ResponseEntity<PersonDTO> {
        val response = personService.getById(id)
        return ResponseEntity.ok().body(response)
    }

    @GetMapping
    fun getAll(): List<PersonDTO> {
        return personService.getAll()
    }

    @PutMapping("/{id}")
    fun updatePerson(@PathVariable id: Long, @RequestBody person: Person): ResponseEntity<*> {
        val response = personService.updatePerson(id, person)
        return ResponseEntity.ok().body(response)
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun deletePerson(@PathVariable id: Long) {
        personService.delete(id)
    }
}






