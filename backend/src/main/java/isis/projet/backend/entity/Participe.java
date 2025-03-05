package isis.projet.backend.entity;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;

@Entity
@Table(name = "participe")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Participe {

    @EmbeddedId
    private ParticipeKey id;

    // Relation vers Etudiant
    @MapsId("idEtudiant")
    @ManyToOne
    @JoinColumn(name = "id_Etudiant")
    private Etudiant etudiant;

    // Relation vers Action
    @MapsId("idAction")
    @ManyToOne
    @JoinColumn(name = "id_Action")
    private Action action;

    // Relation vers Semestre
    @MapsId("idSemestre")
    @ManyToOne
    @JoinColumn(name = "id_Semestre")
    private Semestre semestre;

    @Column(name = "totalPoints", precision = 3, scale = 2)
    private BigDecimal totalPoints;

    private Integer nbParticipation;
}
