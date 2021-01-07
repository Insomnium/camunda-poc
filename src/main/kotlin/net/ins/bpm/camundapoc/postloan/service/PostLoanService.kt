package net.ins.bpm.camundapoc.postloan.service

import net.ins.bpm.camundapoc.postloan.domain.ClientPathState
import net.ins.bpm.camundapoc.postloan.process.BusinessProcessConstants
import net.ins.bpm.camundapoc.postloan.repo.ClientStateRepo
import net.ins.bpm.camundapoc.postloan.repo.enitity.ClientStateEntity
import net.ins.bpm.camundapoc.postloan.repo.enitity.DocumentEntity
import net.ins.bpm.camundapoc.postloan.util.toBusinessKey
import org.camunda.bpm.engine.ProcessEngineServices
import org.camunda.bpm.engine.RuntimeService
import org.camunda.bpm.engine.TaskService
import org.springframework.stereotype.Service
import javax.transaction.Transactional

@Service
class PostLoanService(
        private val runtimeService: RuntimeService,
        private val taskService: TaskService,
        private val clientStateRepo: ClientStateRepo
) {

    @Transactional
    fun runPostLoanProcess(userId: String) {
        clientStateRepo.save(ClientStateEntity(userId, ClientPathState.STARTED, mutableListOf()))

        runtimeService.startProcessInstanceByKey(
                "postLoan",
                userId.toBusinessKey(),
                mapOf(BusinessProcessConstants.USER_ID to userId)
        )
    }

    fun approveOperation(userId: String) {
        taskService.createTaskQuery()
            .processDefinitionKey("postLoan")
            .processInstanceBusinessKey(userId.toBusinessKey())
            .active()
            .taskAssignee(userId)
            .singleResult()
            .let { taskService.complete(it.id) }
    }

    @Transactional
    fun attachDocument(userId: String, fileName: String) {
        val client = clientStateRepo.getOne(userId)
        client.linkDocument(DocumentEntity(null, fileName, client))
    }
}