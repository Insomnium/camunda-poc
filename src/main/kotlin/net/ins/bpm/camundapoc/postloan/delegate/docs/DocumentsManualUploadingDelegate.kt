package net.ins.bpm.camundapoc.postloan.delegate.docs

import mu.KotlinLogging
import net.ins.bpm.camundapoc.postloan.delegate.AbstractClientPathDelegate
import net.ins.bpm.camundapoc.postloan.service.ClientPathStateService
import org.camunda.bpm.engine.delegate.DelegateExecution
import org.springframework.stereotype.Component

@Component
class DocumentsManualUploadingDelegate(
        clientPathStateService: ClientPathStateService
) : AbstractClientPathDelegate(clientPathStateService) {

    private val logger = KotlinLogging.logger {  }

    override fun postExecute(execution: DelegateExecution) {
        logger.info { "manually uploading documents..." }
    }
}