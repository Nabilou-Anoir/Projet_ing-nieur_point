<template>
  <div class="fiche-form-container">
    <h2>Fiche descriptive Ingénieur Engagé</h2>
    <form @submit.prevent="handleSubmit" class="fiche-form">
      <!-- Étudiant : Nom -->
      <div class="form-group">
        <label>Nom <span class="required">*</span></label>
        <input type="text" v-model="nom" placeholder="Saisissez votre nom" required />
      </div>
      <!-- Étudiant : Prénom -->
      <div class="form-group">
        <label>Prénom <span class="required">*</span></label>
        <input type="text" v-model="prenom" placeholder="Saisissez votre prénom" required />
      </div>
      <!-- Étudiant : Promotion -->
      <div class="form-group">
        <label>Promotion <span class="required">*</span></label>
        <input type="text" v-model="promotion" placeholder="ex: FIE3" required />
      </div>

      <!-- Semestre : Année universitaire -->
      <div class="form-group">
        <label>Année universitaire <span class="required">*</span></label>
        <input type="date" v-model="anneeUniversitaire" placeholder="ex: 2023-2024" required />
      </div>
      <!-- Semestre : Numéro -->
      <div class="form-group">
        <label>Semestre <span class="required">*</span></label>
        <select v-model="semestre" required>
          <option disabled value="">-- Sélectionnez un semestre --</option>
          <option v-for="n in 6" :key="n" :value="n">S{{ n }}</option>
        </select>
      </div>

      <!-- Action : Choix du Référentiel (Type d'action) -->
      <div class="form-group">
        <label>Type d'action (Référentiel) <span class="required">*</span></label>
        <select v-model="selectedReferentiel" required>
          <option disabled value="">-- Sélectionnez un référentiel --</option>
          <option v-for="ref in referentiels" :key="ref.idReferentiel" :value="ref.idReferentiel">
            {{ ref.nom }}
          </option>
        </select>
      </div>
      <!-- Action : Date de réalisation -->
      <div class="form-group">
        <label>Date de réalisation <span class="required">*</span></label>
        <input type="date" v-model="dateAction" required />
      </div>
      <!-- Action : Description détaillée -->
      <div class="form-group">
        <label>Description détaillée <span class="required">*</span></label>
        <textarea rows="4" v-model="description" placeholder="Décrivez l’action..." required></textarea>
      </div>

      <!-- Boutons -->
      <div class="btn-group">
        <button type="submit" class="btn-submit">Envoyer</button>
        <button type="button" class="btn-cancel" @click="handleCancel">Annuler</button>
      </div>
    </form>
  </div>
</template>

<script setup>
import { ref, onMounted } from 'vue'
import { useRouter } from 'vue-router'

const router = useRouter()

// Champs du formulaire
const nom = ref('')
const prenom = ref('')
const promotion = ref('')
const anneeUniversitaire = ref('')
const semestre = ref('')            // Valeur de 1 à 6
const selectedReferentiel = ref('') // ID du référentiel sélectionné
const dateAction = ref('')
const description = ref('')

// Réactive pour stocker la liste des référentiels
const referentiels = ref([])

// Endpoints API (ajustez selon votre configuration Swagger)
const ETUDIANTS_URL   = 'http://localhost:8989/api/etudiants'
const SEMESTRES_URL   = 'http://localhost:8989/api/semestres'
const ACTIONS_URL     = 'http://localhost:8989/api/actions'
const PARTICIPES_URL  = 'http://localhost:8989/api/participes'
const REFERENTIELS_URL = 'http://localhost:8989/api/referentiels'

// Charger la liste des référentiels au montage du composant
onMounted(() => {
  chargerReferentiels()
})

function chargerReferentiels() {
  fetch(REFERENTIELS_URL)
    .then(response => {
      if (!response.ok) throw new Error(response.statusText)
      return response.json()
    })
    .then(data => {
      referentiels.value = data
    })
    .catch(error => {
      console.error("Erreur lors du chargement des référentiels:", error)
      alert("Impossible de charger la liste des référentiels.")
    })
}

async function handleSubmit() {
  try {
    // 1. Créer l'étudiant
    const etudiantPayload = {
      nom: nom.value,
      prenom: prenom.value,
      promotion: promotion.value
    }
    const etudiantRes = await fetch(ETUDIANTS_URL, {
      method: 'POST',
      headers: { 'Content-Type': 'application/json' },
      body: JSON.stringify(etudiantPayload)
    })
    if (!etudiantRes.ok) throw new Error('Erreur lors de la création de l’étudiant')
    const etudiantData = await etudiantRes.json()
    const etudiantId = etudiantData.idEtudiant

    // 2. Créer le semestre
    // On extrait l'année de anneeUniversitaire (par exemple, "2023" de "2023-2024")
    const [year] = anneeUniversitaire.value.split('-')
    const anneeStr = `${year}-01-01`
    const semestrePayload = {
      annee: anneeStr,
      numeroSemestre: Number(semestre.value)
    }
    const semestreRes = await fetch(SEMESTRES_URL, {
      method: 'POST',
      headers: { 'Content-Type': 'application/json' },
      body: JSON.stringify(semestrePayload)
    })
    if (!semestreRes.ok) throw new Error('Erreur lors de la création du semestre')
    const semestreData = await semestreRes.json()
    const semestreId = semestreData.idSemestre

    // 3. Créer l'action
    const actionPayload = {
      description: description.value,
      date: dateAction.value,               // La date de réalisation
      idReferentiel: Number(selectedReferentiel.value),
      statut: false,                        // Par défaut, non validée
      commentaire: ''                       // Champ optionnel
    }
    const actionRes = await fetch(ACTIONS_URL, {
      method: 'POST',
      headers: { 'Content-Type': 'application/json' },
      body: JSON.stringify(actionPayload)
    })
    if (!actionRes.ok) throw new Error('Erreur lors de la création de l’action')
    const actionData = await actionRes.json()
    const actionId = actionData.idAction

    // 4. Créer la participation (lien entre étudiant, action et semestre)
    const participePayload = {
      etudiant: etudiantData,
      action: actionData,
      semestre: semestreData
      // Vous pouvez ajouter d'autres champs tels que nbPoints ou nbParticipation si nécessaire
    }
    console.log(participePayload)
    const participeRes = await fetch(PARTICIPES_URL, {
      method: 'POST',
      headers: { 'Content-Type': 'application/json' },
      body: JSON.stringify(participePayload)
    })
    if (!participeRes.ok) throw new Error('Erreur lors de la création de la participation')
    await participeRes.json()

    alert('Fiche envoyée avec succès !')
    router.push('/') // Redirigez vers la page d'accueil ou autre route de votre choix

  } catch (error) {
    console.error("Erreur lors de la soumission :", error)
    alert("Une erreur est survenue lors de l’envoi de la fiche.")
  }
}

function handleCancel() {
  router.push('/')
}
</script>

<style scoped>
.fiche-form-container {
  max-width: 700px;
  margin: 20px auto;
  background-color: #fff;
  border: 1px solid #ddd;
  border-radius: 8px;
  padding: 20px;
}

.fiche-form-container h2 {
  color: #6C3EA9;
  margin-bottom: 1rem;
  border-bottom: 1px solid #6C3EA9;
  padding-bottom: 0.5rem;
}

.fiche-form {
  display: flex;
  flex-direction: column;
}

.form-group {
  margin-bottom: 1rem;
}

.form-group label {
  display: block;
  margin-bottom: 0.4rem;
  font-weight: bold;
  color: #333;
}

.form-group input,
.form-group select,
.form-group textarea {
  width: 100%;
  padding: 8px;
  border-radius: 4px;
  border: 1px solid #ccc;
  box-sizing: border-box;
  font: inherit;
}

.required {
  color: red;
}

.btn-group {
  display: flex;
  gap: 1rem;
  margin-top: 1rem;
}

.btn-submit {
  padding: 10px 20px;
  background-color: #d32f2f;
  color: #fff;
  border: none;
  border-radius: 4px;
  cursor: pointer;
}

.btn-submit:hover {
  background-color: #c12727;
}

.btn-cancel {
  padding: 10px 20px;
  background-color: #ff9800;
  color: #fff;
  border: none;
  border-radius: 4px;
  cursor: pointer;
}

.btn-cancel:hover {
  background-color: #e68900;
}
</style>
