package net.ins.bpm.camundapoc.postloan.service

import mu.KotlinLogging
import net.ins.bpm.camundapoc.postloan.domain.ClientPathState
import org.springframework.stereotype.Service

@Service
class ClientPathStateService {

    private val logger = KotlinLogging.logger {}

    fun setClientPathState(userId: String, clientPathState: ClientPathState) {
        logger.info { "changing user $userId state to $clientPathState" }
    }
}