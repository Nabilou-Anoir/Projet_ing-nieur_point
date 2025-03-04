<!-- src/App.vue -->
<template>
  <div id="app">
    <!-- Barre supérieure -->
    <Topbar />

    <div class="layout">
      <!-- Menu latéral -->
      <Sidebar />

      <!-- Zone de contenu : router-view -->
      <router-view class="main-content" />
    </div>
  </div>
</template>

<script setup>
import Topbar from './components/Topbar.vue'
import Sidebar from './components/Sidebar.vue'
</script>

<style>
#app {
  margin: 0;
  padding: 0;
  font-family: Arial, sans-serif;
  height: 100vh;
  display: flex;
  flex-direction: column;
}

/* Layout principal : sidebar + contenu */
.layout {
  display: flex;
  flex: 1;
}

/* Contenu principal (router-view) */
.main-content {
  flex: 1;
  padding: 20px;
  background-color: #fff;
}
</style>
