<!-- src/components/Topbar.vue -->
<template>
  <nav class="topbar">
    <div class="left-links">
      <!-- Logo ou titre -->
      <router-link to="/" class="logo">
        ISIS Ingénieur Santé Numérique
      </router-link>
    </div>

    <div class="right-links">
      <router-link to="/" class="nav-link">Accueil</router-link>
      <router-link to="/notifications" class="nav-link">Notifications</router-link>
      <router-link to="/profil" class="nav-link">Profil</router-link>
      <router-link to="/logout" class="nav-link">Déconnexion</router-link>
    </div>
  </nav>
</template>

<script setup>
/* Pas de logique spécifique ici */
</script>

<style scoped>
.topbar {
  display: flex;
  align-items: center;
  justify-content: space-between;
  background-color: #6C3EA9; /* Couleur violette */
  padding: 10px 20px;
  color: #fff;
}

/* Zone de gauche */
.left-links .logo {
  font-weight: bold;
  color: #fff;
  text-decoration: none;
  font-size: 1.1rem;
}

/* Zone de droite */
.right-links {
  display: flex;
  gap: 1rem;
}

.nav-link {
  color: #fff;
  text-decoration: none;
  font-weight: 500;
}

.nav-link:hover {
  text-decoration: underline;
}
</style>
