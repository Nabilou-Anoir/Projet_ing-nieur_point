-- 1. Insertion dans la table Semestre
INSERT INTO Semestre (ID_SEMESTRE, ANNEE)
VALUES (1, '2025-01-01');

INSERT INTO Semestre (ID_SEMESTRE, ANNEE)
VALUES (2, '2024-01-01');

--------------------------------------------------
-- 2. Insertion dans la table Etudiant
INSERT INTO Etudiant (ID_ETUDIANT, NOM, PRENOM, EMAIL, PROMOTION)
VALUES (1, 'Durand', 'Pierre', 'pierre.durand@example.com', '2025-2028');

INSERT INTO Etudiant (ID_ETUDIANT, NOM, PRENOM, EMAIL, PROMOTION)
VALUES (2, 'Martin', 'Lucie', 'lucie.martin@example.com', '2024-2027');

INSERT INTO Etudiant (ID_ETUDIANT, NOM, PRENOM, EMAIL, PROMOTION)
VALUES (3, 'Legrand', 'Sophie', 'sophie.legrand@example.com', '2023-2026');

INSERT INTO Etudiant (ID_ETUDIANT, NOM, PRENOM, EMAIL, PROMOTION)
VALUES (4, 'Anoir', 'Nabilou', 'nabilou.anoir@example.com', '2025-2028');

--------------------------------------------------
-- 3. Insertion dans la table Referent
INSERT INTO Referent (ID_REFERENT, NOM, PRENOM, EMAIL)
VALUES (1, 'Dupont', 'Jean', 'jean.dupont@example.com');

INSERT INTO Referent (ID_REFERENT, NOM, PRENOM, EMAIL)
VALUES (2, 'Durand', 'Marie', 'marie.durand@example.com');

--------------------------------------------------
-- 4. Insertion dans la table Referentiel
INSERT INTO Referentiel (ID_REFERENTIEL, NOM, DESCRIPTION)
VALUES (1, 'Referentiel Exemple', 'Description du referentiel exemple');

INSERT INTO Referentiel (ID_REFERENTIEL, NOM, DESCRIPTION)
VALUES (2, 'Referentiel Secondaire', 'Une autre description');

--------------------------------------------------
-- 5. Insertion dans la table Action
-- Chaque action doit référencer un référentiel existant et un référent existant.
INSERT INTO Action (ID_ACTION, DESCRIPTION, STATUT, COMMENTAIRE, ID_REFERENTIEL, ID_REFERENT)
VALUES (1, 'Action de sensibilisation', TRUE, ' Très investie première action', 1, 1);

INSERT INTO Action (ID_ACTION, DESCRIPTION, STATUT, COMMENTAIRE, ID_REFERENTIEL, ID_REFERENT)
VALUES (2, 'Action de formation', FALSE, 'Peu investie', 2, 2);

INSERT INTO Action (id_Action, description, statut, commentaire, id_Referentiel, id_Referent)
VALUES (3, 'Action sans référentiel', TRUE, 'Action non associée à un référentiel', NULL, 1);

--------------------------------------------------
-- 6. Insertion dans la table Participe
-- Notez l'utilisation du nom de colonne "NB_POINTS" tel qu'il existe dans la table.
INSERT INTO Participe (ID_ETUDIANT, ID_ACTION, ID_SEMESTRE, NB_POINTS, NB_PARTICIPATION)
VALUES (1, 1, 1, 0.25, 3);

INSERT INTO Participe (ID_ETUDIANT, ID_ACTION, ID_SEMESTRE, NB_POINTS, NB_PARTICIPATION)
VALUES (2, 2, 1, 0.50, 2);

INSERT INTO Participe (ID_ETUDIANT, ID_ACTION, ID_SEMESTRE, NB_POINTS, NB_PARTICIPATION)
VALUES (3, 1, 1, 0.10, 1);