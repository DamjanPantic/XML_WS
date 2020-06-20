
const state = {
    cart: [],
    itemsInCart: 0,
    requestsByOwner: new Map(),
    owners: []
};

const getters = {
    allCartItems: state => state.cart,
    getCartItemsNumber: state => state.itemsInCart,
    getRequestsByOwner: state => state.requestsByOwner,
    getOwners: state => state.owners
};

const actions = {
    addToCart({ commit }, car){
        commit('itemAddedToCart', car)
    }
};

const mutations = {
    itemAddedToCart: (state, data) => {
        let ind = -1;
        state.cart.forEach((element, index) => {
            if(element.id === data.id)
                ind = index;
        });        
        if(ind !== -1){
            state.cart.splice(ind, 1);
            state.itemsInCart--;    
                    
            var mapIndex = -1;
            state.requestsByOwner.get(data.owner.id).forEach((element, i) => {
                if(element.id === data.id)
                    mapIndex = i;
            });
            
            if(mapIndex > -1){
                console.log("brisanje iz mape");
                
                state.requestsByOwner.get(data.owner.id).splice(mapIndex, 1);
            }

        }else{
            if(!state.requestsByOwner.has(data.owner.id)){
                var ownerRequests = new Array();
                ownerRequests.push(data);
                state.owners.push(data.owner.id);
                state.requestsByOwner.set(data.owner.id,ownerRequests);
            }else{                
                state.requestsByOwner.get(data.owner.id).push(data);
            }          
            state.cart.push(data);
            state.itemsInCart++;
        }
        console.log(state.requestsByOwner);
                
    }
};

export default{
    state,
    getters,
    actions,
    mutations
}