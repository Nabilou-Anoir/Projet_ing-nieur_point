package isis.projet.backend.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Table(name = "Semestre")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Semestre {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Auto-incrément
    @Column(name = "id_Semestre")
    private Integer idSemestre;

    private LocalDate annee;
}
