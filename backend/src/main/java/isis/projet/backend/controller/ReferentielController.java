package isis.projet.backend.controller;

import isis.projet.backend.entity.Referentiel;
import isis.projet.backend.service.ReferentielService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Contrôleur REST pour gérer les opérations CRUD sur l'entité Referentiel.
 *
 * Expose des endpoints pour créer, récupérer, mettre à jour et supprimer des Referentiel.
 */
@RestController
@RequestMapping("/api/referentiels")
@RequiredArgsConstructor
public class ReferentielController {

    // Injection du service pour les Referentiel
    private final ReferentielService referentielService;

    /**
     * Récupère la liste de tous les Referentiel.
     *
     * @return la liste complète des Referentiel.
     */
    @GetMapping
    public List<Referentiel> getAll() {
        return referentielService.findAll();
    }

    /**
     * Récupère un Referentiel par son identifiant.
     *
     * @param id l'identifiant du Referentiel.
     * @return un ResponseEntity contenant le Referentiel ou 404 si non trouvé.
     */
    @GetMapping("/{id}")
    public ResponseEntity<Referentiel> getById(@PathVariable Integer id) {
        return referentielService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    /**
     * Crée un nouveau Referentiel.
     *
     * @param referentiel l'objet Referentiel à créer.
     * @return le Referentiel créé.
     */
    @PostMapping
    public Referentiel create(@RequestBody Referentiel referentiel) {
        return referentielService.save(referentiel);
    }

    /**
     * Met à jour un Referentiel existant.
     *
     * @param id l'identifiant du Referentiel à mettre à jour.
     * @param updated les nouvelles données pour le Referentiel.
     * @return un ResponseEntity contenant le Referentiel mis à jour ou 404 si non trouvé.
     */
    @PutMapping("/{id}")
    public ResponseEntity<Referentiel> update(@PathVariable Integer id, @RequestBody Referentiel updated) {
        return referentielService.findById(id).map(existing -> {
            existing.setNom(updated.getNom());
            existing.setDescription(updated.getDescription());
            return ResponseEntity.ok(referentielService.save(existing));
        }).orElse(ResponseEntity.notFound().build());
    }

    /**
     * Supprime un Referentiel par son identifiant.
     *
     * @param id l'identifiant du Referentiel à supprimer.
     * @return une réponse 204 (No Content) en cas de succès, ou 404 si non trouvé.
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Object> delete(@PathVariable Integer id) {
        return referentielService.findById(id).map(existing -> {
            referentielService.deleteById(id);
            return ResponseEntity.noContent().build();
        }).orElse(ResponseEntity.notFound().build());
    }
}
