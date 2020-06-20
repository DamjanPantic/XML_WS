import router from '../../router'
import { ServiceFactory } from '../../services/ServiceFactory';
const usersService = ServiceFactory.get('users');


const state = {
    user: {},
    token: null
};

const getters = {
    user: state => state.user,
    token: state => state.token
};

const actions = {
    async loginUser({ commit }, user) {
        console.log('logovajne ');

        let response;
        try {
            response = await usersService.login(user);
        } catch (e) {

        }
        await commit('loginUser', response);
        router.push("/");
    },
    async registerUser({ commit }, user) {

        let response;
        try {
            response = await usersService.register(user);

        } catch (e) {

        }
        commit('registerUser', response.headers);
    }
};

const mutations = {
    loginUser: (state, data) => {
        console.log("***************");

        state.token = data.access_token;
        state.user = data.user;
        console.log(data.authorization);
        console.log(data);

        localStorage.setItem('token', data.authorization);
    },
    registerUser: (state, data) => {
        console.log(data.access_token);
        
        state.token = data.access_token,
            state.user = data.user,
            localStorage.setItem('token', data.authorization);

    }
};

export default {
    state,
    getters,
    actions,
    mutations
}