package net.ins.bpm.camundapoc.postloan.delegate

import org.camunda.bpm.engine.delegate.DelegateExecution
import org.camunda.bpm.engine.delegate.JavaDelegate
import org.springframework.stereotype.Component
import java.lang.IllegalStateException

@Component
class FailureDelegate : JavaDelegate {
    override fun execute(execution: DelegateExecution?) {
        throw IllegalStateException("Some failure occurred")
    }
}