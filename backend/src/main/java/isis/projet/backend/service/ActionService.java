package isis.projet.backend.service;

import isis.projet.backend.entity.Action;
import isis.projet.backend.dao.ActionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * Service pour la gestion des entités Action.
 *
 * Fournit des méthodes CRUD pour manipuler les objets Action.
 */
@Service
@RequiredArgsConstructor
public class ActionService {

    // Injection de la dépendance actionRepository.
    private final ActionRepository actionRepository;

    /**
     * Récupère toutes les Actions de la base de données.
     *
     * @return une liste de toutes les Actions.
     */
    public List<Action> findAll() {
        return actionRepository.findAll();
    }

    /**
     * Recherche une Action par son identifiant.
     *
     * @param id l'identifiant de l'Action.
     * @return un Optional contenant l'Action s'il est trouvé.
     */
    public Optional<Action> findById(Integer id) {
        return actionRepository.findById(id);
    }

    /**
     * Sauvegarde ou met à jour une Action dans la base de données.
     *
     * @param action l'objet Action à sauvegarder.
     * @return l'Action sauvegardée.
     */
    public Action save(Action action) {
        return actionRepository.save(action);
    }

    /**
     * Supprime une Action de la base de données par son identifiant.
     *
     * @param id l'identifiant de l'Action à supprimer.
     */
    public void deleteById(Integer id) {
        actionRepository.deleteById(id);
    }
}
