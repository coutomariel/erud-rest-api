package br.com.coutomariel.restwithspringbootandkotlin

import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import javax.validation.ConstraintViolation
import javax.validation.Validation
import javax.validation.Validator
import javax.validation.ValidatorFactory

class GreetingTest {

    lateinit var factory: ValidatorFactory
    lateinit var validator: Validator

    @BeforeEach
    fun setUp() {
        factory = Validation.buildDefaultValidatorFactory()
        validator = Validation.buildDefaultValidatorFactory().validator
    }

    @AfterEach
    fun tearDown() {
        factory.close()
    }


    @Test
    fun `given a invalid zip code, when dto validate then return violation`() {
        val greeting = Greeting(1L, "hELLO World", "95780-0xyz")
        val violations: Set<ConstraintViolation<Greeting>> = validator.validate(greeting)
        val listErrorFields = violations.map { error -> error.propertyPath.toString() }

        Assertions.assertEquals(1, listErrorFields.size)
        Assertions.assertTrue(listErrorFields.contains("zipCode"))
    }
}