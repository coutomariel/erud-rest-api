package br.com.coutomariel.restwithspringbootandkotlin.controller

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
    fun getPerson(@RequestBody person: Person): Person {
        return personService.createPerson(person)
    }

    @GetMapping("/{id}")
    fun getById(@PathVariable id: Long): ResponseEntity<Person> {
        val response = personService.findById(id)
        return ResponseEntity.ok().body(response)
    }

    @GetMapping
    fun getAll(): List<Person> {
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






