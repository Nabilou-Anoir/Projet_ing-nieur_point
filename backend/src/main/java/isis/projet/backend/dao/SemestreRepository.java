package isis.projet.backend.dao;

import isis.projet.backend.entity.Semestre;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SemestreRepository extends JpaRepository<Semestre, Integer> {
}
