package isis.projet.backend.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "Referent")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Referent {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // si vous voulez l'auto-incrément
    @Column(name = "id_Referent")
    private Integer idReferent;

    private String nom;
    private String prenom;
    private String email;

    /**
     * Relation bidirectionnelle avec Action :
     * Un Referent peut "valider" plusieurs Actions.
     * "mappedBy" fait référence à l'attribut "referent" dans la classe Action.
     */
    @OneToMany(mappedBy = "referent", cascade = CascadeType.ALL, orphanRemoval = false)
    @ToString.Exclude
    private List<Action> actions = new ArrayList<>();
}
