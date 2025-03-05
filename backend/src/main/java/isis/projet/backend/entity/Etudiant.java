package isis.projet.backend.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "Etudiant")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Etudiant {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // si vous voulez l'auto-incrément
    @Column(name = "id_Etudiant")
    private Integer idEtudiant;

    private String nom;
    private String prenom;
    private String email;
    private String promotion;

    /**
     * Relation bidirectionnelle avec Participe :
     * Un Etudiant peut participer à plusieurs Actions (et Semestres).
     */
    @OneToMany(mappedBy = "etudiant", cascade = CascadeType.ALL, orphanRemoval = false)
    @ToString.Exclude
    private List<Participe> participations = new ArrayList<>();
}
