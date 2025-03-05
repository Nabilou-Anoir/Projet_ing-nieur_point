package isis.projet.backend.service;

import isis.projet.backend.entity.Referent;
import isis.projet.backend.dao.ReferentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * Service pour la gestion des entités Referent.
 *
 * Ce service fournit des méthodes pour effectuer les opérations CRUD sur
 * les objets Referent en utilisant le ReferentRepository.
 */
@Service // Indique que cette classe est un composant métier géré par Spring.
@RequiredArgsConstructor // Génère un constructeur avec tous les champs final (ici, referentRepository).
public class ReferentService {

    // Injection de la dépendance referentRepository via le constructeur généré par Lombok.
    private final ReferentRepository referentRepository;

    /**
     * Récupère tous les Referent de la base de données.
     *
     * @return une liste de tous les objets Referent.
     */
    public List<Referent> findAll() {
        return referentRepository.findAll();
    }

    /**
     * Recherche un Referent par son identifiant.
     *
     * @param id l'identifiant du Referent.
     * @return un Optional contenant le Referent s'il est trouvé, sinon Optional.empty().
     */
    public Optional<Referent> findById(Integer id) {
        return referentRepository.findById(id);
    }

    /**
     * Sauvegarde ou met à jour un Referent dans la base de données.
     *
     * @param referent l'objet Referent à sauvegarder.
     * @return le Referent sauvegardé.
     */
    public Referent save(Referent referent) {
        return referentRepository.save(referent);
    }

    /**
     * Supprime un Referent de la base de données à partir de son identifiant.
     *
     * @param id l'identifiant du Referent à supprimer.
     */
    public void deleteById(Integer id) {
        referentRepository.deleteById(id);
    }
}
