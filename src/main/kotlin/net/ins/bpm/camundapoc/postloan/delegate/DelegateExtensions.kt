package net.ins.bpm.camundapoc.postloan.delegate

import net.ins.bpm.camundapoc.postloan.domain.ClientPathState
import net.ins.bpm.camundapoc.postloan.process.BusinessProcessConstants
import org.camunda.bpm.engine.delegate.DelegateExecution
import org.camunda.bpm.engine.variable.value.StringValue

fun DelegateExecution.getClientId(): String = getVariableTyped<StringValue>(BusinessProcessConstants.USER_ID).value

fun DelegateExecution.getClientPathStatus(): ClientPathState = ClientPathState.valueOf(getVariableTyped<StringValue>(BusinessProcessConstants.CLIENT_PATH_STATE).value)