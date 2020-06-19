import Vue from 'vue'
import Vuex from 'vuex'
import users from './modules/users';
import rental from './modules/rental';

Vue.use(Vuex)

export default new Vuex.Store({
  modules: {
      users,
      rental

  }
})
