package net.ins.bpm.camundapoc.postloan.repo.enitity

import net.ins.bpm.camundapoc.postloan.domain.ClientPathState
import javax.persistence.*
import javax.persistence.EnumType.STRING

@Entity
@Table(name = "client_state")
data class ClientStateEntity(
    @Id val id: String,
    @Enumerated(STRING) var pathState: ClientPathState,
    @OneToMany(mappedBy = "client", orphanRemoval = true, cascade = [CascadeType.PERSIST, CascadeType.REMOVE])
    val documents: MutableList<DocumentEntity>
) {

    fun linkDocument(document: DocumentEntity) {
        documents += document
        document.client = this
    }
}