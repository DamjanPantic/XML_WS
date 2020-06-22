import Vue from 'vue'
import Vuex from 'vuex'

import vehicles from './modules/vehicles';
import user from './modules/user';
import reports from './modules/reports';

Vue.use(Vuex)

export default new Vuex.Store({
  modules: {
      vehicles,
      user,
      reports
  }
})
