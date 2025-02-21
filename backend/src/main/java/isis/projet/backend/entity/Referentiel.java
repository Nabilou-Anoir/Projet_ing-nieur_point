package isis.projet.backend.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "Referentiel")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Referentiel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // si vous voulez l'auto-incrément
    @Column(name = "id_Referentiel")
    private Integer idReferentiel;

    private String nom;

    @Lob
    private String description;

    /**
     * Relation bidirectionnelle avec Action :
     * Un Referentiel peut être lié à plusieurs Actions.
     */
    @OneToMany(mappedBy = "referentiel", cascade = CascadeType.ALL, orphanRemoval = false)
    @ToString.Exclude
    private List<Action> actions = new ArrayList<>();
}
