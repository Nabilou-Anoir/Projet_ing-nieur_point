package isis.projet.backend.controller;

import isis.projet.backend.entity.Action;
import isis.projet.backend.service.ActionService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Contrôleur REST pour gérer les opérations CRUD sur l'entité Action.
 *
 * Expose des endpoints pour créer, récupérer, mettre à jour et supprimer des Action.
 */
@RestController
@RequestMapping("/api/actions")
@RequiredArgsConstructor
public class ActionController {

    // Injection du service pour les Action
    private final ActionService actionService;

    /**
     * Récupère la liste de toutes les Actions.
     *
     * @return la liste complète des Action.
     */
    @GetMapping
    public List<Action> getAll() {
        return actionService.findAll();
    }

    /**
     * Récupère une Action par son identifiant.
     *
     * @param id l'identifiant de l'Action.
     * @return un ResponseEntity contenant l'Action ou 404 si non trouvée.
     */
    @GetMapping("/{id}")
    public ResponseEntity<Action> getById(@PathVariable Integer id) {
        return actionService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    /**
     * Crée une nouvelle Action.
     *
     * @param action l'objet Action à créer.
     * @return l'Action créée.
     */
    @PostMapping
    public Action create(@RequestBody Action action) {
        return actionService.save(action);
    }

    /**
     * Met à jour une Action existante.
     *
     * @param id l'identifiant de l'Action à mettre à jour.
     * @param updated les nouvelles données pour l'Action.
     * @return un ResponseEntity contenant l'Action mise à jour ou 404 si non trouvée.
     */
    @PutMapping("/{id}")
    public ResponseEntity<Action> update(@PathVariable Integer id, @RequestBody Action updated) {
        return actionService.findById(id).map(existing -> {
            existing.setDescription(updated.getDescription());
            existing.setStatut(updated.getStatut());
            existing.setCommentaire(updated.getCommentaire());
            existing.setReferentiel(updated.getReferentiel());
            existing.setReferent(updated.getReferent());
            return ResponseEntity.ok(actionService.save(existing));
        }).orElse(ResponseEntity.notFound().build());
    }

    /**
     * Supprime une Action par son identifiant.
     *
     * @param id l'identifiant de l'Action à supprimer.
     * @return une réponse 204 (No Content) en cas de succès, ou 404 si non trouvée.
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Object> delete(@PathVariable Integer id) {
        return actionService.findById(id).map(existing -> {
            actionService.deleteById(id);
            return ResponseEntity.noContent().build();
        }).orElse(ResponseEntity.notFound().build());
    }
}
