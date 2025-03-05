// src/router/index.js
import { createRouter, createWebHistory } from 'vue-router'

// Import des vues
import AccueilView from '@/views/AccueilView.vue'
import NotificationsView from '@/views/NotificationsView.vue'
import ProfilView from '@/views/ProfilView.vue'
import SaisirFicheView from '@/views/SaisirFicheView.vue'
import HistoriqueFichesView from '@/views/HistoriqueFichesView.vue'
import ActiviteHorsRefView from '@/views/ActiviteHorsRefView.vue'

const routes = [
  { path: '/', component: AccueilView },
  { path: '/notifications', component: NotificationsView },
  { path: '/profil', component: ProfilView },
  { path: '/saisir-fiche', component: SaisirFicheView },
  { path: '/historique-fiches', component: HistoriqueFichesView },
  { path: '/activite-hors-ref', component: ActiviteHorsRefView },
]

const router = createRouter({
  history: createWebHistory(),
  routes
})

export default router
