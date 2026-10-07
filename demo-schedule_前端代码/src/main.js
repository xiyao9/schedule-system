import { createApp } from 'vue'

import App from './App.vue'
import pinia from './pinia.js'
import router from './router/router.js'
const app = createApp(App)
app.use(router)
app.use(pinia)
app.mount('#app')
