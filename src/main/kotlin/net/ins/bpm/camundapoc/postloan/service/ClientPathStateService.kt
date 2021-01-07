package net.ins.bpm.camundapoc.postloan.service

import mu.KotlinLogging
import net.ins.bpm.camundapoc.postloan.domain.ClientPathState
import net.ins.bpm.camundapoc.postloan.repo.ClientStateRepo
import net.ins.bpm.camundapoc.postloan.repo.enitity.ClientStateEntity
import org.springframework.stereotype.Service
import javax.transaction.Transactional

@Service
class ClientPathStateService(
    private val clientStateRepo: ClientStateRepo
) {

    private val logger = KotlinLogging.logger {}

    @Transactional
    fun setClientPathState(userId: String, clientPathState: ClientPathState): ClientStateEntity {
        logger.info { "changing user $userId state to $clientPathState" }
        with(clientStateRepo.getOne(userId)) {
            pathState = clientPathState
            return this
        }
    }

    fun getClientPathState(userId: String) = clientStateRepo.getOne(userId)
}