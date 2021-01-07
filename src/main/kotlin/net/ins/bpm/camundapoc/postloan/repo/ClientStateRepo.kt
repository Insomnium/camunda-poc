package net.ins.bpm.camundapoc.postloan.repo

import net.ins.bpm.camundapoc.postloan.repo.enitity.ClientStateEntity
import org.springframework.data.jpa.repository.JpaRepository

interface ClientStateRepo : JpaRepository<ClientStateEntity, String>