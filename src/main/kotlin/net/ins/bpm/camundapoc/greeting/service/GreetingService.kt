package net.ins.bpm.camundapoc.greeting.service

import org.camunda.bpm.engine.RuntimeService
import org.springframework.stereotype.Service

@Service
class GreetingService(
        val runtimeService: RuntimeService
) {

    fun runGreetingJob(name: String, timeout: String) = runtimeService.startProcessInstanceByKey("sample_process", mapOf(
            "name" to name,
            "timeout" to timeout
    ))
}