package net.ins.bpm.camundapoc.postloan.util

import net.ins.bpm.camundapoc.postloan.domain.ClientState
import net.ins.bpm.camundapoc.postloan.domain.Document
import net.ins.bpm.camundapoc.postloan.repo.enitity.ClientStateEntity
import net.ins.bpm.camundapoc.postloan.repo.enitity.DocumentEntity

fun ClientStateEntity.toDTO(): ClientState = ClientState(this.id, this.pathState, this.documents.map { it.toDTO() })

fun DocumentEntity.toDTO(): Document = Document(this.id!!, this.fileName)