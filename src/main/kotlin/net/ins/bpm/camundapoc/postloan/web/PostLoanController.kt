package net.ins.bpm.camundapoc.postloan.web

import net.ins.bpm.camundapoc.postloan.service.PostLoanService
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/post-loan")
class PostLoanController(
        private val postLoanService: PostLoanService
) {

    @PostMapping
    fun onboard(@RequestHeader("x-user-id") userId: String) {
        postLoanService.runPostLoanProcess(userId)
    }
}