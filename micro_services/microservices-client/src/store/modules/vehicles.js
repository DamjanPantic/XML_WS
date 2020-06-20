import { ServiceFactory } from '../../services/ServiceFactory';
const searchService = ServiceFactory.get('search');

const state = {
    vehicles: [],
    totalPages: 1
};

const getters = {
    vehicles: state => state.vehicles,
    totalPages: state => state.totalPages,
};

const actions = {
    async getAllVehiclesByPage({ commit }, pageNo) {
        console.log('Getting Vehicles...');

        let response;
        try {
            response = await searchService.getVehiclesByPage(pageNo);
        } catch (e) {

        }
        commit('setTotalPages', response.data.totalPages);
        commit('setVehicles', response.data.content);
    }
};

const mutations = {
    setVehicles: (state, data) => {
        // console.log(data);

        state.vehicles = data;
    },
    setTotalPages: (state, data) => {
        state.totalPages = data;
    }
};

export default {
    state,
    getters,
    actions,
    mutations
}