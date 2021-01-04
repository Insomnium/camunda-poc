package net.ins.bpm.camundapoc.postloan.delegate.docs

import mu.KotlinLogging
import org.camunda.bpm.engine.delegate.DelegateExecution
import org.camunda.bpm.engine.delegate.JavaDelegate
import org.springframework.stereotype.Component

@Component
class DocumentsRetrievalDelegate : JavaDelegate {

    private val logger = KotlinLogging.logger {}

    override fun execute(execution: DelegateExecution) {
        logger.info { "retrieving documents from master-system..." }
    }
}