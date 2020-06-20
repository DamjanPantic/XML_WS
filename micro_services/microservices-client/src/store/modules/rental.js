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
    async acceptDeclineRequest({commit}, approveObj) {
        let response;
        try{
            response = await rentalService.acceptDeclineRequest(approveObj);
            commit('requestApprovedDenied', approveObj.requestId)
        }catch(e){

        }
    }
};

const mutations = {
    requestsFetched: (state, data) => {
        state.requests = data;
    },
    requestApprovedDenied: (state,data) => {
        state.requests = state.requests.filter(request => request.id != data)
    }
};

export default{
    state,
    getters,
    actions,
    mutations
}