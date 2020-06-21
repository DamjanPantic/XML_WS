import router from '../../router'
import { ServiceFactory } from '../../services/ServiceFactory';
const messageService = ServiceFactory.get('message');


const state = {
    messages: [],
};

const getters = {
    messages: state => state.messages,
};

const actions = {
    async sendMessage({ commit }, message) {
        console.log('slanje poruke..');

        let response;
        try {
            response = await messageService.sendMessage(message);
            commit('setMessages', response.data);
        } catch (e) { }
    },
    async getRequestConversation({ commit }, requestId) {

        let response;
        try {
            response = await messageService.getConversation(requestId);
            commit('setMessages', response.data);
        } catch (e) {

        }
    },
};

const mutations = {
    setMessages: (state, data) => {
        state.messages = data;
    },
};

export default {
    state,
    getters,
    actions,
    mutations
}