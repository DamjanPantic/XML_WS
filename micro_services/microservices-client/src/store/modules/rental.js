import { ServiceFactory } from '../../services/ServiceFactory';
const rentalService = ServiceFactory.get('rental');

const state = {
    requests: [],
    sentRequest: null
};

const getters = {
    allRequests: state => state.requests,
    getSentRequest: state => state.sendRequest
};

const actions = {
    async fetchRequests({ commit }, owner) {        
        let response;
        try{
            response = await rentalService.fetchPendingRequests(owner);

        }catch(e){
            
        }        
        commit('requestsFetched', response.data);
    },
    async acceptDeclineRequest({commit}, approveObj) {
        let response;
        try{
            response = await rentalService.acceptDeclineRequest(approveObj);
            commit('requestApprovedDenied', approveObj)
        }catch(e){

        }
    },
    async sendRequest({commit}, rentalRequestObj) {
        let response;
        try{
            response = await rentalService.sendRequest(rentalRequestObj);
            commit('rentalRequestSent')
        }catch(e){

        }
    }
};

const mutations = {
    requestsFetched: (state, data) => {
        state.requests = data;
    },
    requestApprovedDenied: (state,data) => {
        console.log(data);
        
        if(data.approve === true){
            state.requests = state.requests.filter(request => request.vehicleBasicDTO.id != data.vehicleId)
        }else{
            state.requests = state.requests.filter(request => request.id != data.requestId)
        }
    },
    rentalRequestSent: (state, data) => {
        state.sentRequest = true;
    }
};

export default{
    state,
    getters,
    actions,
    mutations
}