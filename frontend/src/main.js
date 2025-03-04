// src/main.js
import { createApp } from 'vue'
import App from './App.vue'
import router from './router' // pas besoin d'indiquer '/index.js'

const app = createApp(App)
app.use(router)
app.mount('#app')
