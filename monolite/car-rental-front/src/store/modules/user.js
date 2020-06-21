import router from '../../router'
import { ServiceFactory } from '../../services/ServiceFactory';
const authService = ServiceFactory.get('auth');


const state = {
    user: null,
};

const getters = {
    user: state => state.user,
};

const actions = {
    async loginUser({ commit }, user) {
        let response;
        try {
            response = await authService.login(user);
            await commit('loginUser', response.data);
            router.push("/");
        } catch (e) { }
    },
    async registerUser({ commit }, user) {
        let response;
        try {
            response = await authService.register(user);
            router.push("/login");
        } catch (e) {

        }
    },
    logoutUser({ commit }){
        commit('logoutUser');
        router.push("/login");
    }
};

const mutations = {
    loginUser: (state, data) => {
        state.user = data;
    },
    logoutUser: () => {
        state.user = null;
    },
};

export default {
    state,
    getters,
    actions,
    mutations
}