<template>
  <div id="asd">
    <v-list>
      <template v-for="(item) in getOwners">
        <v-divider  v-bind:key="item"></v-divider>
        <v-list-item :key="item.id">
          <v-list-item-content>
            <v-list>
                <template v-for="(car) in getRequestsByOwner.get(item)">
                    <v-divider  v-bind:key="car.id+100"></v-divider>
                    <v-list-item :key="car.id">
                    <v-list-item-content>
                        <v-list-item-title
                        v-html="'Car: '+ car.model.manufacturer.name+' '+car.model.name "
                        ></v-list-item-title>
                        <v-list-item-title
                        v-html="'Owner: '+ car.owner.email"
                        ></v-list-item-title>

                    </v-list-item-content>
                    </v-list-item>
                </template>
            </v-list>
                  <v-switch @change="change(item)" v-if="getRequestsByOwner.get(item).length > 1" class="mx-2" label="Bundle"></v-switch>
          </v-list-item-content>
        </v-list-item>
      </template>
    </v-list>
    <div id = "calendar">
        from
        <datetime format="MM-DD-YYYY H:i" v-model='fromDate' ></datetime>
        to
        <datetime format="MM-DD-YYYY H:i" v-model='toDate' ></datetime>
    </div>
    <v-btn
          class="mx-1"
          color="primary"
          @click="confirm"
        >
          Confirm
        </v-btn>
  </div>
</template>

<script>
import datetime from 'vuejs-datetimepicker';
import { mapGetters, mapActions } from "vuex";

export default {
  name: "Cart",
  components:{
    datetime
  },
  methods: {
    ...mapActions(["addToCart"]),
    remove(car){
    },
    change(item){        
        if(this.requestsByOwner[item] === true){
            this.requestsByOwner.set(item, false)
        }
        else{
            this.requestsByOwner[item] = true;
            this.requestsByOwner.set(item, true)
        }        
        console.log(this.requestsByOwner);
        
    },
    insertRequests(){        
        this.getOwners.forEach(element => {            
            if(!this.requestsByOwner.has(element)){
                this.requestsByOwner.set(element,false);
            }
        });        
    },
    confirm(){
        console.log("confitm", this.getRequestsByOwner);
        console.log(this.fromDate, this.toDate);
        
        
    }
  },
  data: () => ({
    bundle: null,
    requestsByOwner: new Map(),
    fromDate: null,
    toDate: null
  }),
  computed: mapGetters(["allCartItems", "getOwners", 'getRequestsByOwner']),
  created() {
    this.insertRequests();
  }
};
</script>

<style scoped>
#asd {
  position: fixed;
  height: calc(100vh - 64px) !important;
  width: 100%;
  top: 64px !important;
  overflow: scroll !important;
  margin: unset !important;
}
#slika{
    max-width: 20%;
}

#bundleBtn{
    max-width: 10%;
}

#calendar{
    max-width: 10%;
}
</style>