package isis.projet.backend.service;

import isis.projet.backend.entity.Referentiel;
import isis.projet.backend.dao.ReferentielRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * Service pour la gestion des entités Referentiel.
 *
 * Fournit des méthodes CRUD pour manipuler les objets Referentiel.
 */
@Service
@RequiredArgsConstructor
public class ReferentielService {

    // Injection de la dépendance referentielRepository.
    private final ReferentielRepository referentielRepository;

    /**
     * Récupère tous les Referentiel de la base de données.
     *
     * @return une liste de tous les objets Referentiel.
     */
    public List<Referentiel> findAll() {
        return referentielRepository.findAll();
    }

    /**
     * Recherche un Referentiel par son identifiant.
     *
     * @param id l'identifiant du Referentiel.
     * @return un Optional contenant le Referentiel s'il est trouvé.
     */
    public Optional<Referentiel> findById(Integer id) {
        return referentielRepository.findById(id);
    }

    /**
     * Sauvegarde ou met à jour un Referentiel dans la base de données.
     *
     * @param referentiel l'objet Referentiel à sauvegarder.
     * @return le Referentiel sauvegardé.
     */
    public Referentiel save(Referentiel referentiel) {
        return referentielRepository.save(referentiel);
    }

    /**
     * Supprime un Referentiel de la base de données par son identifiant.
     *
     * @param id l'identifiant du Referentiel à supprimer.
     */
    public void deleteById(Integer id) {
        referentielRepository.deleteById(id);
    }
}
