package isis.projet.backend.service;

import isis.projet.backend.entity.Semestre;
import isis.projet.backend.dao.SemestreRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * Service pour la gestion des entités Semestre.
 *
 * Fournit des méthodes CRUD pour manipuler les objets Semestre.
 */
@Service
@RequiredArgsConstructor
public class SemestreService {

    // Injection de la dépendance semestreRepository.
    private final SemestreRepository semestreRepository;

    /**
     * Récupère tous les Semestre de la base de données.
     *
     * @return une liste de tous les objets Semestre.
     */
    public List<Semestre> findAll() {
        return semestreRepository.findAll();
    }

    /**
     * Recherche un Semestre par son identifiant.
     *
     * @param id l'identifiant du Semestre.
     * @return un Optional contenant le Semestre s'il est trouvé.
     */
    public Optional<Semestre> findById(Integer id) {
        return semestreRepository.findById(id);
    }

    /**
     * Sauvegarde ou met à jour un Semestre dans la base de données.
     *
     * @param semestre l'objet Semestre à sauvegarder.
     * @return le Semestre sauvegardé.
     */
    public Semestre save(Semestre semestre) {
        System.out.println( semestre.toString());
        return semestreRepository.save(semestre);
    }

    /**
     * Supprime un Semestre de la base de données par son identifiant.
     *
     * @param id l'identifiant du Semestre à supprimer.
     */
    public void deleteById(Integer id) {
        semestreRepository.deleteById(id);
    }
}
