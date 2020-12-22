package net.ins.bpm.camundapoc.postloan.service

import net.ins.bpm.camundapoc.postloan.domain.ProgramType
import org.springframework.stereotype.Service

@Service
class ProgramService {

    fun defineProgram(userId: String): ProgramType = with(userId.replaceFirst("0", "").toInt()) {
        when {
            this % 2 == 0 -> ProgramType.TARGET
            else -> ProgramType.NON_TARGET
        }
    }
}