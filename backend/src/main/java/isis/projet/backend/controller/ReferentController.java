package isis.projet.backend.controller;

import isis.projet.backend.entity.Referent;
import isis.projet.backend.service.ReferentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Contrôleur REST pour gérer les opérations CRUD sur l'entité Referent.
 */
@RestController
@RequestMapping("/api/referents")
@RequiredArgsConstructor
public class ReferentController {

    private final ReferentService referentService;

    /**
     * Récupère la liste de tous les Referent.
     *
     * @return la liste complète des Referent.
     */
    @GetMapping
    public List<Referent> getAll() {
        return referentService.findAll();
    }

    /**
     * Récupère un Referent par son identifiant.
     *
     * @param id l'identifiant du Referent.
     * @return le Referent trouvé ou 404.
     */
    @GetMapping("/{id}")
    public ResponseEntity<Referent> getById(@PathVariable Integer id) {
        return referentService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    /**
     * Crée un nouveau Referent.
     *
     * @param referent l'objet Referent à créer.
     * @return le Referent créé.
     */
    @PostMapping
    public Referent create(@RequestBody Referent referent) {
        return referentService.save(referent);
    }

    /**
     * Met à jour un Referent existant.
     *
     * @param id l'identifiant du Referent à mettre à jour.
     * @param updated les nouvelles données du Referent.
     * @return le Referent mis à jour ou 404.
     */
    @PutMapping("/{id}")
    public ResponseEntity<Referent> update(@PathVariable Integer id, @RequestBody Referent updated) {
        return referentService.findById(id)
                .map(existing -> {
                    existing.setNom(updated.getNom());
                    existing.setPrenom(updated.getPrenom());
                    existing.setEmail(updated.getEmail());
                    return ResponseEntity.ok(referentService.save(existing));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    /**
     * Supprime un Referent par son identifiant.
     *
     * @param id l'identifiant du Referent à supprimer.
     * @return une réponse 204 (No Content) en cas de succès, ou 404 si non trouvé.
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Object> delete(@PathVariable Integer id) {
        return referentService.findById(id)
                .map(existing -> {
                    referentService.deleteById(id);
                    return ResponseEntity.noContent().build();
                })
                .orElse(ResponseEntity.notFound().build());
    }
}
