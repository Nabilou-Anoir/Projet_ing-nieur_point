package isis.projet.backend.controller;

import isis.projet.backend.entity.Etudiant;
import isis.projet.backend.service.EtudiantService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Contrôleur REST pour gérer les opérations CRUD sur l'entité Etudiant.
 *
 * Expose des endpoints pour créer, récupérer, mettre à jour et supprimer des Etudiant.
 */
@RestController
@RequestMapping("/api/etudiants")
@RequiredArgsConstructor
public class EtudiantController {

    // Injection du service pour les Etudiant
    private final EtudiantService etudiantService;

    /**
     * Récupère la liste de tous les Etudiant.
     *
     * @return la liste complète des Etudiant.
     */
    @GetMapping
    public List<Etudiant> getAll() {
        return etudiantService.findAll();
    }

    /**
     * Récupère un Etudiant par son identifiant.
     *
     * @param id l'identifiant de l'Etudiant.
     * @return un ResponseEntity contenant l'Etudiant ou une réponse 404 si non trouvé.
     */
    @GetMapping("/{id}")
    public ResponseEntity<Etudiant> getById(@PathVariable Integer id) {
        return etudiantService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    /**
     * Crée un nouveau Etudiant.
     *
     * @param etudiant l'objet Etudiant à créer.
     * @return le Etudiant créé.
     */
    @PostMapping
    public Etudiant create(@RequestBody Etudiant etudiant) {
        return etudiantService.save(etudiant);
    }

    /**
     * Met à jour un Etudiant existant.
     *
     * @param id l'identifiant de l'Etudiant à mettre à jour.
     * @param updated les nouvelles données de l'Etudiant.
     * @return un ResponseEntity contenant l'Etudiant mis à jour ou 404 si non trouvé.
     */
    @PutMapping("/{id}")
    public ResponseEntity<Etudiant> update(@PathVariable Integer id, @RequestBody Etudiant updated) {
        return etudiantService.findById(id).map(existing -> {
            existing.setNom(updated.getNom());
            existing.setPrenom(updated.getPrenom());
            existing.setEmail(updated.getEmail());
            existing.setPromotion(updated.getPromotion());
            return ResponseEntity.ok(etudiantService.save(existing));
        }).orElse(ResponseEntity.notFound().build());
    }

    /**
     * Supprime un Etudiant par son identifiant.
     *
     * @param id l'identifiant de l'Etudiant à supprimer.
     * @return une réponse 204 (No Content) en cas de succès, ou 404 si non trouvé.
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Object> delete(@PathVariable Integer id) {
        return etudiantService.findById(id).map(existing -> {
            etudiantService.deleteById(id);
            return ResponseEntity.noContent().build();
        }).orElse(ResponseEntity.notFound().build());
    }
}
