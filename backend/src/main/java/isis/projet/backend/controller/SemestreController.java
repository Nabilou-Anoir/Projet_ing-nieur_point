package isis.projet.backend.controller;

import isis.projet.backend.entity.Semestre;
import isis.projet.backend.service.SemestreService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Contrôleur REST pour gérer les opérations CRUD sur l'entité Semestre.
 *
 * Expose des endpoints pour créer, récupérer, mettre à jour et supprimer des Semestre.
 */
@RestController
@RequestMapping("/api/semestres")
@RequiredArgsConstructor
public class SemestreController {

    // Injection du service pour les Semestre
    private final SemestreService semestreService;

    /**
     * Récupère la liste de tous les Semestre.
     *
     * @return la liste complète des Semestre.
     */
    @GetMapping
    public List<Semestre> getAll() {
        return semestreService.findAll();
    }

    /**
     * Récupère un Semestre par son identifiant.
     *
     * @param id l'identifiant du Semestre.
     * @return un ResponseEntity contenant le Semestre ou 404 si non trouvé.
     */
    @GetMapping("/{id}")
    public ResponseEntity<Semestre> getById(@PathVariable Integer id) {
        return semestreService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    /**
     * Crée un nouveau Semestre.
     *
     * @param semestre l'objet Semestre à créer.
     * @return le Semestre créé.
     */
    @PostMapping
    public Semestre create(@RequestBody Semestre semestre) {
        return semestreService.save(semestre);
    }

    /**
     * Met à jour un Semestre existant.
     *
     * @param id l'identifiant du Semestre à mettre à jour.
     * @param updated les nouvelles données pour le Semestre.
     * @return un ResponseEntity contenant le Semestre mis à jour ou 404 si non trouvé.
     */
    @PutMapping("/{id}")
    public ResponseEntity<Semestre> update(@PathVariable Integer id, @RequestBody Semestre updated) {
        return semestreService.findById(id).map(existing -> {
            existing.setAnnee(updated.getAnnee());
            return ResponseEntity.ok(semestreService.save(existing));
        }).orElse(ResponseEntity.notFound().build());
    }

    /**
     * Supprime un Semestre par son identifiant.
     *
     * @param id l'identifiant du Semestre à supprimer.
     * @return une réponse 204 (No Content) en cas de succès, ou 404 si non trouvé.
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Object> delete(@PathVariable Integer id) {
        return semestreService.findById(id).map(existing -> {
            semestreService.deleteById(id);
            return ResponseEntity.noContent().build();
        }).orElse(ResponseEntity.notFound().build());
    }
}
