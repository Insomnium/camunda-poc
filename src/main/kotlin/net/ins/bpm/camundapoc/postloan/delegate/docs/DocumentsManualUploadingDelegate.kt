package net.ins.bpm.camundapoc.postloan.delegate.docs

import mu.KotlinLogging
import net.ins.bpm.camundapoc.postloan.delegate.getClientId
import net.ins.bpm.camundapoc.postloan.process.BusinessProcessConstants
import net.ins.bpm.camundapoc.postloan.repo.ClientStateRepo
import org.camunda.bpm.engine.delegate.DelegateExecution
import org.camunda.bpm.engine.delegate.JavaDelegate
import org.springframework.stereotype.Component

@Component
class DocumentsManualUploadingDelegate(
    private val clientStateRepo: ClientStateRepo
) : JavaDelegate {

    private val logger = KotlinLogging.logger {  }

    override fun execute(execution: DelegateExecution) {
        logger.info { "Checking manual docs uploading state" }
        val clientPathState = clientStateRepo.getOne(execution.getClientId())
        execution.setVariable(BusinessProcessConstants.DOCS_UPLOAD_COMPLETE, clientPathState.documents.isNotEmpty())
    }
}