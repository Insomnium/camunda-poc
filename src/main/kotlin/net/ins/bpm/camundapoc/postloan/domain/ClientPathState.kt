package net.ins.bpm.camundapoc.postloan.domain

enum class ClientPathState {
    STARTED,
    ONBOARDED,
    DOCS_UPLOADING,
    DOCS_UPLOADED,
    DOCS_RETRIEVAL,
    DOCS_RECOGNITION_CONFIRMATION,
    COMPLETE
}