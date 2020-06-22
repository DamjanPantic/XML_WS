import { ServiceFactory } from '../../services/ServiceFactory';
const vehicleService = ServiceFactory.get('vehicle');

const state = {
    manufacturers: [],
    models: [],
    fuels: [],
    transmissions: [],
    vehicleTypes: [],
    priceTypes: [],
};

const getters = {
    manufacturers: state => state.manufacturers,
    models: state => state.models,
    fuels: state => state.fuels,
    transmissions: state => state.transmissions,
    vehicleTypes: state => state.vehicleTypes,
    priceTypes: state => state.priceTypes,
};

const actions = {
    async addVehicle({ commit }, vehicle) {

        let response;
        try {
            response = await vehicleService.addVehicle(vehicle);
        } catch (e) { }
    },
    async getDataForAddingVehicle({ commit }) {

        try {
            let responseManufacturers = await vehicleService.getManufacturers();
            commit('setManufacturers', responseManufacturers.data);

            let responseFuels = await vehicleService.getFuels();
            commit('setFuels', responseFuels.data);

            let responseTransmissions = await vehicleService.getTransmissions();
            commit('setTransmissions', responseTransmissions.data);

            let responseVehicleTypes = await vehicleService.getVehicleTypes();
            commit('setVehicleTypes', responseVehicleTypes.data);

            let responsePriceTypes = await vehicleService.getPriceTypes();
            commit('setPriceTypes', responsePriceTypes.data);
        } catch (e) { }
    },
    async getModelFromManufacturerName({ commit }, manufacturerName) {

        let response;
        try {
            response = await vehicleService.getModelFromManufacturerName(manufacturerName);
            commit('setModels', response.data)
        } catch (e) { }
    },
};

const mutations = {
    setManufacturers: (state, data) => {
        state.manufacturers = data;
    },
    setModels: (state, data) => {
        state.models = data;
    },
    setFuels: (state, data) => {
        state.fuels = data;
    },
    setTransmissions: (state, data) => {
        state.transmissions = data;
    },
    setVehicleTypes: (state, data) => {
        state.vehicleTypes = data;
    },
    setPriceTypes: (state, data) => {
        state.priceTypes = data;
    },
};

export default {
    state,
    getters,
    actions,
    mutations
}