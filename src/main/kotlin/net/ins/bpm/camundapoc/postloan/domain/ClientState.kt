package net.ins.bpm.camundapoc.postloan.domain

data class ClientState(val id: String, val state: ClientPathState, val documents: List<Document>)