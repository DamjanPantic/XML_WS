<template>
  <v-container>
    <v-row>
      <vehicle-card v-for="i in 12" :key="i" />
    </v-row>
    
    <v-row justify="center" class="mt-10">
      <v-pagination v-model="page" :length="length" circle></v-pagination>
    </v-row>
  </v-container>
</template>

<script>
import VehicleCard from "../components/VehicleCard.vue";

export default {
  components: {
    VehicleCard
  },
  data() {
    return {
      page: 1,
      length: 3
    };
  }
};
</script>

<style>
</style>