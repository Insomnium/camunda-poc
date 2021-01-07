package net.ins.bpm.camundapoc.postloan.repo.enitity

import javax.persistence.*

@Entity
@Table(name = "documents")
data class DocumentEntity(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) val id: Long?,
    var fileName: String,
    @ManyToOne(fetch = FetchType.LAZY)
    var client: ClientStateEntity
)