package isis.projet.backend.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "Referentiel")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Referentiel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Auto-incrément
    @Column(name = "id_Referentiel")
    private Integer idReferentiel;

    private String nom;

    @Lob
    private String description;
}
