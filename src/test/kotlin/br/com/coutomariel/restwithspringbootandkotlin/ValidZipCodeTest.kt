package br.com.coutomariel.restwithspringbootandkotlin

import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.springframework.boot.test.context.SpringBootTest
import javax.validation.ConstraintViolation
import javax.validation.Validation
import javax.validation.Validator
import javax.validation.ValidatorFactory

@SpringBootTest
class ValidZipCodeTest {

    lateinit var factory: ValidatorFactory
    lateinit var validator: Validator

    @BeforeEach
    fun setUp() {
        factory = Validation.buildDefaultValidatorFactory()
        validator = factory.validator
    }

    @AfterEach
    fun tearDown() {
        factory.close()
    }

    @Test
    fun `teste`() {
        val toValidate = Greeting(1L, description = null, zipCode = "95a80-320")
        val violations: Set<ConstraintViolation<Greeting>> = validator.validate(toValidate)

        val attributes = violations.map { v -> v.propertyPath.toString() }
        with(attributes) {
            assertEquals(2, this.size)
            assertTrue(this.contains("zipCode"))
            assertTrue(this.contains("description"))
        }
    }
}