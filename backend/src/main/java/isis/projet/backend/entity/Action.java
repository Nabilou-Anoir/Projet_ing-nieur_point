package isis.projet.backend.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "Action")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Action {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Auto-incrément
    @Column(name = "id_Action")
    private Integer idAction;

    @Lob
    private String description;

    private Boolean statut;

    @Lob
    private String commentaire;

    @ManyToOne
    @JoinColumn(name = "id_Referentiel")
    private Referentiel referentiel;

    @ManyToOne
    @JoinColumn(name = "id_Referent")
    private Referent referent;
}
