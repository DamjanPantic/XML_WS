import Vue from 'vue'
import App from './App.vue'
import router from './router/index';
import store from './store';
import VueJwtDecode from "vue-jwt-decode";
import vuetify from '@/plugins/vuetify' // path to vuetify export
import '@mdi/font/css/materialdesignicons.css'

Vue.config.productionTip = false

new Vue({
  store,
  router,
  vuetify,
  render: h => h(App)
}).$mount('#app')
