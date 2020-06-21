import { ServiceFactory } from '../../services/ServiceFactory';
const rentalService = ServiceFactory.get('rental');

const state = {
    requests: [],
    sentRequest: null,
    reservedRequests: [],
    payment: null
};

const getters = {
    allRequests: state => state.requests,
    getSentRequest: state => state.sendRequest,
    getReservedRequests: state => state.reservedRequests,
    getRequest: state => state.payment
};

const actions = {
    async fetchRequests({ commit }, owner) {
        let response;
        try {
            response = await rentalService.fetchPendingRequests(owner);

        } catch (e) {

        }
        commit('requestsFetched', response.data);
    },
    async acceptDeclineRequest({ commit }, approveObj) {
        let response;
        try {
            response = await rentalService.acceptDeclineRequest(approveObj);
            commit('requestApprovedDenied', approveObj)
        } catch (e) {

        }
    },
    async userRentalRequest({ commit }, user) {
        let response;
        try {
            response = await rentalService.getUserRentalRequest(user);
            commit('setRequests', response.data)
        } catch (e) {

        }
    },
    async sendRequest({commit}, rentalRequestObj) {
        let response;
        try{
            response = await rentalService.sendRequest(rentalRequestObj);
            commit('rentalRequestSent')
        }catch(e){

        }
    },
    async fetchReservedRequests({ commit }, customer) {
        let response;
        try {
            response = await rentalService.fetchReservedRequests(customer);

        } catch (e) {

        }
        commit('reservedRequestsFetched', response.data);
    },

    proceedPayment({ commit }, request) {
        commit('procced', request);
    },

    async pay({commit}, requestId){
        let response;
        try {
            response = await rentalService.payRequest(requestId);

        } catch (e) {

        }
    }
};

const mutations = {
    requestsFetched: (state, data) => {
        state.requests = data;
    },
    requestApprovedDenied: (state, data) => {
        console.log(data);

        if (data.approve === true) {
            state.requests = state.requests.filter(request => request.vehicleBasicDTO.id != data.vehicleId)
        } else {
            state.requests = state.requests.filter(request => request.id != data.requestId)
        }
    },
    rentalRequestSent: (state, data) => {
        state.sentRequest = true;
    },
    setRequests: (state, data) => {
        state.requests = data;
        console.log(data);
    },
    reservedRequestsFetched: (state, data) => {
        state.reservedRequests = data;
    },
    procced: (state, data) => {
        state.payment = data;
    }
};

export default {
    state,
    getters,
    actions,
    mutations
}