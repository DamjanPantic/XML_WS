import router from '../../router'
import { ServiceFactory } from '../../services/ServiceFactory';
const commentService = ServiceFactory.get('comment');


const state = {
    comments: [],
};

const getters = {
    comments: state => state.comments,
};

const actions = {
    async fetchComments({ commit }, id) {
        let response;
        try {
            response = await commentService.getComments(id);
            await commit('fetchComments', response.data);
        } catch (e) { }
    },
};

const mutations = {
    fetchComments: (state, data) => {
        state.comments = data;
    },
};

export default {
    state,
    getters,
    actions,
    mutations
}