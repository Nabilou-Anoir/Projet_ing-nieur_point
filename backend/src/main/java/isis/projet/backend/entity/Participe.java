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

    @MapsId("idEtudiant")
    @ManyToOne
    @JoinColumn(name = "id_Etudiant")
    private Etudiant etudiant;

    @MapsId("idAction")
    @ManyToOne
    @JoinColumn(name = "id_Action")
    private Action action;

    @MapsId("idSemestre")
    @ManyToOne
    @JoinColumn(name = "id_Semestre")
    private Semestre semestre;

    @Column(name = "totalPoints", precision = 3, scale = 2)
    private BigDecimal totalPoints;

    private Integer nbParticipation;
}
