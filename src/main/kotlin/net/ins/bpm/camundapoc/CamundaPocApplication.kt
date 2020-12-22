package net.ins.bpm.camundapoc

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class CamundaPocApplication

fun main(args: Array<String>) {
    runApplication<CamundaPocApplication>(*args)
}
