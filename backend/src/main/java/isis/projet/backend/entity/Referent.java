package isis.projet.backend.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "Referent")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Referent {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_Referent")
    private Integer idReferent;

    private String nom;
    private String prenom;
    private String email;
}
