package net.ins.bpm.camundapoc.postloan.web

import net.ins.bpm.camundapoc.postloan.domain.ClientState
import net.ins.bpm.camundapoc.postloan.service.ClientPathStateService
import net.ins.bpm.camundapoc.postloan.service.PostLoanService
import net.ins.bpm.camundapoc.postloan.util.toDTO
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/post-loan")
class PostLoanController(
        private val postLoanService: PostLoanService,
        private val clientPathStateService: ClientPathStateService
) {

    @PostMapping
    fun onboard(@RequestHeader("x-user-id") userId: String) {
        postLoanService.runPostLoanProcess(userId)
    }

    @GetMapping("/{userId}/state")
    fun clientState(@PathVariable("userId") userId: String): ClientState =
        clientPathStateService.getClientPathState(userId).toDTO()

    @PostMapping("/attachment")
    fun attachFile(@RequestHeader("x-user-id") userId: String,
                   @RequestHeader("x-file-name") fileName: String) {
        postLoanService.attachDocument(userId, fileName)
    }

    @PostMapping("/{userId}/approval")
    fun approveOperation(@PathVariable("userId") userId: String) {
        postLoanService.approveOperation(userId)
    }
}