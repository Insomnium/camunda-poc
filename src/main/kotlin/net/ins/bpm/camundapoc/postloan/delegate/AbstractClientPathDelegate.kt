package net.ins.bpm.camundapoc.postloan.delegate

import net.ins.bpm.camundapoc.postloan.service.ClientPathStateService
import org.camunda.bpm.engine.delegate.DelegateExecution
import org.camunda.bpm.engine.delegate.JavaDelegate

abstract class AbstractClientPathDelegate(
        private val clientPathStateService: ClientPathStateService
) : JavaDelegate {

    override fun execute(execution: DelegateExecution) {
        clientPathStateService.setClientPathState(execution.getUserId(), execution.getClientPathStatus())
        postExecute(execution)
    }

    abstract fun postExecute(execution: DelegateExecution)
}