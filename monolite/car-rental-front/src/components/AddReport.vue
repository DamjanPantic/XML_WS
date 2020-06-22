<template>
    <v-form
    ref="form"
    v-model="valid"
    lazy-validation
  >
    <v-text-field
      v-model="distance"
      label="Distance"
      required
    ></v-text-field>

    <v-text-field
      v-model="info"
      label="Info"
      required
    ></v-text-field>

    <v-select
      v-model="request"
      :items="requests"
      label="Request"
      required
    ></v-select>

    <v-select
      v-model="vehicle"
      :items="vehicles"
      label="Vehicle"
      required
    ></v-select>

    <v-btn
      color="success"
      class="mr-4"
      @click="onClickHandler"
    >
      Validate
    </v-btn>
  </v-form>
</template>

<script>
import { mapGetters, mapActions } from "vuex";

export default {
    computed: mapGetters(["user"]),
    methods: {
        ...mapActions(['logoutUser', 'addReport']),
        async onClickHandler(){
            const report = {
                distance: this.distance,
                info: this.info,
                vehicleId: this.vehicle,
                requestId: this.request
            }      
            await this.addReport(report);
            alert("report added")      
            
        }

    },
    data: () => ({
        info: "",
        distance: "",
        request: null,
        vehicle: null,
        requests: [
            '1',
            '2',
            '3',
            '4',
        ],
        vehicles: [
            '1',
            '2',
            '3',
            '4'
        ],

        checkbox: false,
    }),

};
</script>

<style>
</style>