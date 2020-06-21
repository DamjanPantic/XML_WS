import router from '../../router'
import VueJwtDecode from "vue-jwt-decode";
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
            await commit('loginUser', response.headers);
            router.push("/");
        } catch (e) { }

    
        console.log("hederi" + response.headers);
        
        commit('loginUser', response.headers);
        await commit('loginUser', response);
        router.push("/");
    },
    async registerUser({ commit }, user) {

        let response;
        try {
            response = await usersService.register(user);
            router.push("/login");
        } catch (e) {

        }
        // commit('registerUser', response.headers);
    },
    logoutUser({ commit }){
        commit('logoutUser');
    },
    refreshUser({ commit }, jwt){
        commit('refreshUser', jwt);
    }
};

const mutations = {
    loginUser: (state, data) => {
        state.token = data.authorization;
        let decodedJWT = VueJwtDecode.decode(data.authorization.split(" ")[1]);
        state.user = { "id": decodedJWT.id, "username": decodedJWT.username };
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

    },
    logoutUser: () => {
        state.token = null;
        state.user = {};
        localStorage.removeItem('token');
    },
    refreshUser: (state, jwt) => {
        state.token = jwt;
        let decodedJWT = VueJwtDecode.decode(jwt.split(" ")[1]);
        state.user = { "id": decodedJWT.id, "username": decodedJWT.username };
    }
};

export default {
    state,
    getters,
    actions,
    mutations
}