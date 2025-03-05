package isis.projet.backend.entity;

import jakarta.persistence.Embeddable;
import lombok.*;

import java.io.Serializable;

@Embeddable
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ParticipeKey implements Serializable {

    private Integer idEtudiant;
    private Integer idAction;
    private Integer idSemestre;
}
