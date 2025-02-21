package isis.projet.backend.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "Etudiant")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Etudiant {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_Etudiant")
    private Integer idEtudiant;

    private String nom;
    private String prenom;
    private String email;
    private String promotion;
}
