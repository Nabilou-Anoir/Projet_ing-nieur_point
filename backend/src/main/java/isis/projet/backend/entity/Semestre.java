package isis.projet.backend.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "Semestre")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Semestre {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // si vous voulez l'auto-incrément
    @Column(name = "id_Semestre")
    private Integer idSemestre;

    private LocalDate annee;

    private Integer numeroSemestre;

    /**
     * Relation bidirectionnelle avec Participe :
     * Un Semestre peut contenir plusieurs participations.
     */
    @OneToMany(mappedBy = "semestre", cascade = CascadeType.ALL, orphanRemoval = false)
    @ToString.Exclude
    private List<Participe> participations = new ArrayList<>();
}
