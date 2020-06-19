<template>
  <v-container>
    <v-row>
      <vehicle-card v-for="vehicle in vehicles" :key="vehicle.id" :vehicle="vehicle"/>
    </v-row>

    <v-row justify="center" class="mt-10">
      <v-pagination v-model="page" :length="totalPages" circle @input="getAllVehiclesByPage(page)"></v-pagination>
    </v-row>
  </v-container>
</template>

<script>
import VehicleCard from "../components/VehicleCard.vue";
import { mapGetters, mapActions } from "vuex";

export default {
  components: {
    VehicleCard
  },
  data() {
    return {
      page: 1
    };
  },
  methods: {
    ...mapActions(["getAllVehiclesByPage"])
  },
  computed: {
    ...mapGetters(["vehicles", "totalPages"])
  },
  mounted() {
    this.getAllVehiclesByPage(this.page);
  }
};
</script>

<style>
</style>