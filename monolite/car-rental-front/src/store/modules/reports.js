import { ServiceFactory } from '../../services/ServiceFactory';
const reportService = ServiceFactory.get('report');

const state = {
    
};

const getters = {
  
};

const actions = {
    async addReport({ commit }, report) {
        console.log("add report");
        
        let response;
        try {
            response = await reportService.addReport(report);
        }catch (e) {

        }
        console.log(response);
        
    }
};

const mutations = {
};

export default {
    state,
    getters,
    actions,
    mutations
}