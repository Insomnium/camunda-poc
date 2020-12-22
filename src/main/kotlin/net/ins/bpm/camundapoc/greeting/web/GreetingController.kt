package net.ins.bpm.camundapoc.greeting.web

import net.ins.bpm.camundapoc.greeting.service.GreetingService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping(path = ["/greeting"])
class GreetingController(
        val greetingService: GreetingService
) {

    @PostMapping("/{name}")
    fun runProcess(
            @PathVariable("name") name: String,
            @RequestParam("timeout") timeout: String // e.g. PT10S for 10 seconds
    ): ResponseEntity<Void> {
        greetingService.runGreetingJob(name, timeout)
        return ResponseEntity.accepted().build<Void>()
    }

}