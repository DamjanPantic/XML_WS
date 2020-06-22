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
          <div class="rating">
            <div v-if="token" style="display:flex; align-items:center;">
              <span
                v-if="ratingValue !== 'NaN'"
                class="grey--text text--darken-2"
              >({{ Math.round(ratingValue * 100) / 100 }})</span>
              <span v-else class="grey--text text--darken-2">(0)</span>
              <v-rating
                v-model="asd"
                color="blue darken-1"
                background-color="blue darken-4"
                half-increments
                @input="rating"
                :readonly="asd !== 0"
                hover
                dense
              ></v-rating>
            </div>
            <div v-else style="display:flex; align-items:center;">
              <span
                v-if="ratingValue !== 'NaN'"
                class="grey--text text--darken-2"
              >({{ Math.round(ratingValue * 100) / 100 }})</span>
              <span v-else class="grey--text text--darken-2">(0)</span>
              <v-rating
                :value="ratingValue ==='NaN'? 0 : ratingValue"
                color="blue darken-1"
                background-color="blue darken-4"
                dense
                half-increments
                readonly
              ></v-rating>
            </div>
          </div>
        </v-card-text>

        <v-card-actions>
          <v-btn :to="'/vehicle/'+vehicle.id" color="blue darken-2" text left>Info</v-btn>
          <v-spacer />
          <v-btn icon color="red" right>
            <v-icon>mdi-heart-outline</v-icon>
          </v-btn>
          <v-btn icon color="red" right>
            <v-icon @click="addItemToCart">mdi-cart</v-icon>
          </v-btn>
        </v-card-actions>
        <p v-if="this.addedToCart" color="red">Added to cart!</p>
      </v-card>
    </v-row>
  </v-col>
</template>

<script>
import { mapGetters, mapActions } from "vuex";

import { ServiceFactory } from "../services/ServiceFactory.js";
const recensionService = ServiceFactory.get("recension");

export default {
  props: ["vehicle"],
  methods: {
    ...mapActions(["addToCart"]),
    rating(e) {
      let response = recensionService.addGrade({
        vehicleId: this.vehicle.id,
        userId: this.user.id,
        gradeValue: e
      });

      
      response
        .then(result => {
          console.log(result);
          this.ratingValue = result.data;
        })
        .catch(e => {
          alert(e.response.data);
          this.asd = 0;
        });
    },
    addItemToCart() {
      this.addToCart(this.vehicle);
      if (this.addedToCart === true) {
        this.addedToCart = false;
      } else {
        this.addedToCart = true;
      }
    },
    remove() {
      this.addedToCart = null;
    },
    check() {
      let ind = -1;
      this.allCartItems.forEach((element, index) => {
        if (element.id === this.vehicle.id) {
          ind = index;
        }
      });
      if (ind !== -1) {
        this.addedToCart = true;
      } else {
      }
    }
  },
  data: () => ({
    addedToCart: null,
    asd: 0,
    ratingValue: 0
  }),
  computed: mapGetters(["allCartItems", "user", "token"]),
  created() {
    this.check();
  },
  mounted() {
    let response = recensionService.getRating(this.vehicle.id);
    response
      .then(result => {
        this.ratingValue = result.data;
      })
      .catch(e => {
        alert(e.response.data);
      });

    let response1 = recensionService.getGradeByUser(
      this.vehicle.id,
      this.user.id
    );
    response1
      .then(result => {
        this.asd = result.data;
      })
      .catch(e => {
      });
  }
};
</script>

<style>
.rating {
  display: inline-block;
  align-items: center;
}
</style>