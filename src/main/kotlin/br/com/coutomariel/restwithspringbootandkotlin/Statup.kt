package br.com.coutomariel.restwithspringbootandkotlin

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class Statup

fun main(args: Array<String>) {
	runApplication<Statup>(*args)
}
