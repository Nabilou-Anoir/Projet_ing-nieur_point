package isis.projet.backend.dao;

import isis.projet.backend.entity.Participe;
import isis.projet.backend.entity.ParticipeKey;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ParticipeRepository extends JpaRepository<Participe, ParticipeKey> {
}
