import Vue from 'vue'
import Vuex from 'vuex'
import users from './modules/users';
import rental from './modules/rental';
import vehicles from './modules/vehicles';
import message from './modules/message'; 
import recension from './modules/recension'; 

Vue.use(Vuex)

export default new Vuex.Store({
  modules: {
      users,
      rental,
      vehicles,
      message,
      recension
  }
})
