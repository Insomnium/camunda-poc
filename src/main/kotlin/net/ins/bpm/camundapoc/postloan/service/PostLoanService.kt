package net.ins.bpm.camundapoc.postloan.service

import net.ins.bpm.camundapoc.postloan.process.BusinessProcessConstants
import net.ins.bpm.camundapoc.postloan.util.toBusinessKey
import org.camunda.bpm.engine.RuntimeService
import org.springframework.stereotype.Service

@Service
class PostLoanService(
        private val runtimeService: RuntimeService
) {

    fun runPostLoanProcess(userId: String) {
        runtimeService.startProcessInstanceByKey(
                "postLoan",
                userId.toBusinessKey(),
                mapOf(BusinessProcessConstants.USER_ID to userId)
        )
    }
}