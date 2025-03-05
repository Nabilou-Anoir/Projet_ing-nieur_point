package isis.projet.backend.controller;

import isis.projet.backend.entity.Participe;
import isis.projet.backend.entity.ParticipeKey;
import isis.projet.backend.service.ParticipeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Contrôleur REST pour gérer les opérations CRUD sur l'entité Participe.
 *
 * La table Participe est une table d'association utilisant une clé composite (id_Etudiant, id_Action, id_Semestre).
 * Ce contrôleur expose les endpoints pour créer, récupérer, mettre à jour et supprimer des participations.
 */
@RestController
@RequestMapping("/api/participe")
@RequiredArgsConstructor
public class ParticipeController {

    // Injection du service pour la gestion des participations
    private final ParticipeService participeService;

    /**
     * Récupère la liste de toutes les participations.
     *
     * @return la liste complète des participations.
     */
    @GetMapping
    public List<Participe> getAll() {
        return participeService.findAll();
    }

    /**
     * Récupère une participation via les identifiants composant la clé (id_Etudiant, id_Action, id_Semestre).
     *
     * @param idEtudiant l'identifiant de l'Etudiant.
     * @param idAction l'identifiant de l'Action.
     * @param idSemestre l'identifiant du Semestre.
     * @return un ResponseEntity contenant la participation si trouvée, sinon 404.
     */
    @GetMapping("/etudiant/{idEtudiant}/action/{idAction}/semestre/{idSemestre}")
    public ResponseEntity<Participe> getById(@PathVariable Integer idEtudiant,
                                             @PathVariable Integer idAction,
                                             @PathVariable Integer idSemestre) {
        ParticipeKey key = new ParticipeKey(idEtudiant, idAction, idSemestre);
        return participeService.findById(key)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    /**
     * Crée une nouvelle participation.
     *
     * L'objet Participe doit contenir la clé composite ainsi que les données de nbPoints et nbParticipation.
     *
     * @param participe l'objet Participe à créer.
     * @return la participation créée.
     */
    @PostMapping
    public Participe create(@RequestBody Participe participe) {
        return participeService.save(participe);
    }

    /**
     * Met à jour une participation existante.
     *
     * @param idEtudiant l'identifiant de l'Etudiant.
     * @param idAction l'identifiant de l'Action.
     * @param idSemestre l'identifiant du Semestre.
     * @param updated l'objet Participe contenant les nouvelles données.
     * @return un ResponseEntity contenant la participation mise à jour ou 404 si non trouvée.
     */
    @PutMapping("/etudiant/{idEtudiant}/action/{idAction}/semestre/{idSemestre}")
    public ResponseEntity<Participe> update(@PathVariable Integer idEtudiant,
                                            @PathVariable Integer idAction,
                                            @PathVariable Integer idSemestre,
                                            @RequestBody Participe updated) {
        ParticipeKey key = new ParticipeKey(idEtudiant, idAction, idSemestre);
        return participeService.findById(key).map(existing -> {
            existing.setTotalPoints(updated.getTotalPoints());
            existing.setNbParticipation(updated.getNbParticipation());
            return ResponseEntity.ok(participeService.save(existing));
        }).orElse(ResponseEntity.notFound().build());
    }

    /**
     * Supprime une participation via la clé composite.
     *
     * @param idEtudiant l'identifiant de l'Etudiant.
     * @param idAction   l'identifiant de l'Action.
     * @param idSemestre l'identifiant du Semestre.
     * @return une réponse 204 (No Content) en cas de succès, ou 404 si non trouvée.
     */
    @DeleteMapping("/etudiant/{idEtudiant}/action/{idAction}/semestre/{idSemestre}")
    public ResponseEntity<Object> delete(@PathVariable Integer idEtudiant,
                                         @PathVariable Integer idAction,
                                         @PathVariable Integer idSemestre) {
        ParticipeKey key = new ParticipeKey(idEtudiant, idAction, idSemestre);
        return participeService.findById(key).map(existing -> {
            participeService.deleteById(key);
            return ResponseEntity.noContent().build();
        }).orElse(ResponseEntity.notFound().build());
    }
}
