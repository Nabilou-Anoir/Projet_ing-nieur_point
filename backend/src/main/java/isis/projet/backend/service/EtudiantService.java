package isis.projet.backend.service;

import isis.projet.backend.entity.Etudiant;
import isis.projet.backend.dao.EtudiantRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * Service pour la gestion des entités Etudiant.
 *
 * Fournit les méthodes CRUD pour manipuler les objets Etudiant.
 */
@Service
@RequiredArgsConstructor
public class EtudiantService {

    // Injection de la dépendance etudiantRepository.
    private final EtudiantRepository etudiantRepository;

    /**
     * Récupère tous les Etudiant de la base de données.
     *
     * @return une liste de tous les objets Etudiant.
     */
    public List<Etudiant> findAll() {
        return etudiantRepository.findAll();
    }

    /**
     * Recherche un Etudiant par son identifiant.
     *
     * @param id l'identifiant de l'Etudiant.
     * @return un Optional contenant l'Etudiant s'il existe.
     */
    public Optional<Etudiant> findById(Integer id) {
        return etudiantRepository.findById(id);
    }

    /**
     * Sauvegarde ou met à jour un Etudiant dans la base de données.
     *
     * @param etudiant l'objet Etudiant à sauvegarder.
     * @return l'Etudiant sauvegardé.
     */
    public Etudiant save(Etudiant etudiant) {
        return etudiantRepository.save(etudiant);
    }

    /**
     * Supprime un Etudiant de la base de données à partir de son identifiant.
     *
     * @param id l'identifiant de l'Etudiant à supprimer.
     */
    public void deleteById(Integer id) {
        etudiantRepository.deleteById(id);
    }
}
