import Vue from 'vue'
import Vuex from 'vuex'

import vehicles from './modules/vehicles';
import user from './modules/user';
import grade from './modules/grade';
import comment from './modules/comment';


Vue.use(Vuex)

export default new Vuex.Store({
  modules: {
      vehicles,
      user,
      comment,
      grade
  }
})
