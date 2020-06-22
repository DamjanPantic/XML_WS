import router from '../../router'
import { ServiceFactory } from '../../services/ServiceFactory';
const gradeService = ServiceFactory.get('grade');


const state = {
    grades: [],
};

const getters = {
    grades: state => state.grades,
};

const actions = {
    async fetchGrades({ commit }, id) {
        let response;
        try {
            response = await gradeService.getGrades(id);
            await commit('fetchGrades', response.data);
        } catch (e) { }
    },
};

const mutations = {
    fetchGrades: (state, data) => {
        state.grades = data;
    },
};

export default {
    state,
    getters,
    actions,
    mutations
}