<template>
  <v-col xl="3" md="4" sm="6" xs="12">
    <v-row justify="center">
      <v-card loading="true" height="100%">
        <v-img src="https://vrelegume.rs/wp-content/uploads/2020/03/Screenshot_20200303_100626.jpg"></v-img>

        <v-card-title>
          <v-icon>{{vehicle.model.manufacturer.name}}, {{vehicle.model.name}}</v-icon>
          <v-spacer />
          <v-tooltip bottom>
            <template v-slot:activator="{ on, attrs }">
              <v-chip color="blue" outlined v-bind="attrs" v-on="on">
                <v-avatar left>
                  <v-icon>mdi-account-circle-outline</v-icon>
                </v-avatar>
                {{vehicle.owner.username}}
              </v-chip>
            </template>
            <span>Owner</span>
          </v-tooltip>
        </v-card-title>

        <v-card-text>
          <v-row>
            <v-col cols="12">
              <v-tooltip bottom>
                <template v-slot:activator="{ on, attrs }">
                  <span v-bind="attrs" v-on="on" style="cursor: auto;">
                    <v-icon color="green">mdi-cash</v-icon>
                    <v-icon>100$</v-icon>
                  </span>
                </template>
                <span>Price per day</span>
              </v-tooltip>
            </v-col>
          </v-row>
          <!-- <v-row>
            <v-col cols="6">
              <v-tooltip bottom>
                <template v-slot:activator="{ on, attrs }" class="justify-center">
                  <span v-bind="attrs" v-on="on">
                    <v-icon color="gray">mdi-cash-multiple</v-icon>
                    <span class="ml-1">20$</span>
                  </span>
                </template>
                <span>Price of additional kilometer</span>
              </v-tooltip>
            </v-col>
            <v-col cols="6">
              <v-tooltip bottom>
                <template v-slot:activator="{ on, attrs }" class="justify-center">
                  <span v-bind="attrs" v-on="on">
                    <v-icon color="gray">mdi-map-marker-distance</v-icon>
                    <span class="ml-1">{{vehicle.limitKm}}</span>
                  </span>
                </template>
                <span>Distance limit</span>
              </v-tooltip>
            </v-col>
          </v-row>
          <v-row>
            <v-col cols="6">
              <v-tooltip bottom>
                <template v-slot:activator="{ on, attrs }" class="justify-center">
                  <span v-bind="attrs" v-on="on">
                    <v-icon color="gray">mdi-car-shift-pattern</v-icon>
                    <span class="ml-1">{{vehicle.transmission.name}}</span>
                  </span>
                </template>
                <span>Transmission type</span>
              </v-tooltip>
            </v-col>
            <v-col cols="6">
              <v-tooltip bottom>
                <template v-slot:activator="{ on, attrs }" class="justify-center">
                  <span v-bind="attrs" v-on="on">
                    <v-icon color="gray">mdi-gas-station-outline</v-icon>
                    <span class="ml-1">{{vehicle.fuelType.type}}</span>
                  </span>
                </template>
                <span>Fuel type</span>
              </v-tooltip>
            </v-col>
          </v-row>-->
        </v-card-text>

        <v-card-actions>
          <v-btn color="blue darken-2" text left>Info</v-btn>
          <v-spacer />
          <v-btn icon color="red" right>
            <v-icon>mdi-heart-outline</v-icon>
          </v-btn>
          <v-btn icon color="red" right>
            <v-icon @click="addItemToCart">mdi-cart</v-icon>
          </v-btn>
        </v-card-actions>
        <p v-if="this.addedToCart" color = "red">Added to cart!</p>
      </v-card>
    </v-row>
  </v-col>
</template>

<script>
import { mapGetters, mapActions } from "vuex";


export default {
  props: ["vehicle"],
   methods: {
    ...mapActions(["addToCart"]),
    addItemToCart() {
      this.addToCart(this.vehicle);
      if(this.addedToCart === true){
        this.addedToCart = false;
      }else{
        this.addedToCart = true;
      }
    },
    remove(){
      this.addedToCart = null;
    },
    check(){
      let ind = -1;
      this.allCartItems.forEach((element,index) => {
        if(element.id === this.vehicle.id){
          ind = index;
        }
      });
      if(ind !== -1){          
          this.addedToCart = true;
      }else{
          
      }
    }
  },
  data: () => ({
    addedToCart: null
  }),
  computed: mapGetters(["allCartItems"]),
  created() {
    this.check();
  }

};
</script>

<style>
</style>