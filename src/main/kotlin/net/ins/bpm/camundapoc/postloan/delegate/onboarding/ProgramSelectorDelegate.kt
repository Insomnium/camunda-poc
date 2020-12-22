package net.ins.bpm.camundapoc.postloan.delegate.onboarding

import mu.KotlinLogging
import net.ins.bpm.camundapoc.postloan.delegate.AbstractClientPathDelegate
import net.ins.bpm.camundapoc.postloan.delegate.getUserId
import net.ins.bpm.camundapoc.postloan.process.BusinessProcessConstants
import net.ins.bpm.camundapoc.postloan.service.ClientPathStateService
import net.ins.bpm.camundapoc.postloan.service.ProgramService
import org.camunda.bpm.engine.delegate.DelegateExecution
import org.springframework.stereotype.Component

@Component
class ProgramSelectorDelegate(
        private val programService: ProgramService,
        clientPathStateService: ClientPathStateService
) : AbstractClientPathDelegate(clientPathStateService) {

    private val logger = KotlinLogging.logger{}

    override fun postExecute(execution: DelegateExecution) {
        logger.info { "determining program for businessKey: ${execution.businessKey}" }
        val programType = programService.defineProgram(execution.getUserId())
//        execution.variables[BusinessProcessConstants.PROGRAM_ID] = programType
        execution.setVariable(BusinessProcessConstants.PROGRAM_ID, programType)
    }
}