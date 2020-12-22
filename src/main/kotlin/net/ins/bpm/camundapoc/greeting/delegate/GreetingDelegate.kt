package net.ins.bpm.camundapoc.greeting.delegate

import org.camunda.bpm.engine.delegate.DelegateExecution
import org.camunda.bpm.engine.delegate.JavaDelegate

class GreetingDelegate : JavaDelegate {

    override fun execute(execution: DelegateExecution?) {
        println("Hello, ${execution?.getVariable("name")}")
    }
}