package net.ins.bpm.camundapoc.postloan.delegate.docs

import mu.KotlinLogging
import net.ins.bpm.camundapoc.postloan.process.BusinessProcessConstants
import org.camunda.bpm.engine.delegate.DelegateExecution
import org.camunda.bpm.engine.delegate.JavaDelegate
import org.springframework.stereotype.Component

@Component
class DocumentsManualUploadingDelegate : JavaDelegate {

    private val logger = KotlinLogging.logger {  }

    override fun execute(execution: DelegateExecution) {
        logger.info { "Checking manual docs uploading state" }
        var debug = false
        execution.setVariable(BusinessProcessConstants.DOCS_UPLOAD_COMPLETE, debug)
    }
}