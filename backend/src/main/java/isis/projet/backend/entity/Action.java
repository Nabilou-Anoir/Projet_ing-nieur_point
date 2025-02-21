package isis.projet.backend.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "Action")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Action {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // si vous voulez l'auto-incrément
    @Column(name = "id_Action")
    private Integer idAction;

    @Lob
    private String description;

    // "statut LOGICAL" => on le mappe en Boolean
    private Boolean statut;

    @Lob
    private String commentaire;

    /**
     * Relation ManyToOne vers Referentiel :
     * Une Action "appartient" à un seul Referentiel,
     * mais un Referentiel peut avoir plusieurs Actions.
     */
    @ManyToOne
    @JoinColumn(name = "id_Referentiel")
    private Referentiel referentiel;

    /**
     * Relation ManyToOne vers Referent :
     * Une Action est "validée" par un seul Referent,
     * mais un Referent peut valider plusieurs Actions.
     */
    @ManyToOne
    @JoinColumn(name = "id_Referent")
    private Referent referent;

    /**
     * Relation bidirectionnelle avec Participe :
     * Une Action peut avoir plusieurs participations d'étudiants.
     */
    @OneToMany(mappedBy = "action", cascade = CascadeType.ALL, orphanRemoval = false)
    @ToString.Exclude
    private List<Participe> participations = new ArrayList<>();
}
