
const state = {
    cart: []
};

const getters = {
    allCartItems: state => state.cart,
};

const actions = {
    addToCart({ commit }, car){
        commit('itemAddedToCart', car)
    }
};

const mutations = {
    itemAddedToCart: (state, data) => {
        if(state.cart.includes(data)){
            var index = state.cart.indexOf(data);
            if (index > -1) {
                state.cart.splice(index, 1);
            }
        }else{
            state.cart.push(data);
        }
        console.log(state.cart);
        
    }
};

export default{
    state,
    getters,
    actions,
    mutations
}