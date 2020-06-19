import { ServiceFactory } from '../../services/ServiceFactory';
const rentalService = ServiceFactory.get('rental');


const state = {
    requests: []
};

const getters = {
    allRequests: state => state.requests,
};

const actions = {
    async fetchRequests({ commit }, owner) {        
        let response;
        try{
            response = await rentalService.fetchPendingRequests(owner);

        }catch(e){
            
        }        
        console.log(response.data);
        commit('requestsFetched', response.data);
    },
};

const mutations = {
    requestsFetched: (state, data) => {
        state.requests = data;
    }
};

export default{
    state,
    getters,
    actions,
    mutations
}