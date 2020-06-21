import Vue from 'vue'
import Vuex from 'vuex'
import users from './modules/users';
import rental from './modules/rental';
import vehicles from './modules/vehicles';
import cart from './modules/cart';
import message from './modules/message'; 

Vue.use(Vuex)

export default new Vuex.Store({
  modules: {
      users,
      rental,
      vehicles,
      cart,
      message,
  }
})