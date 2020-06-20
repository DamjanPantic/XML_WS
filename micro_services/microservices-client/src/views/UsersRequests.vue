<template>
  <v-container>
    <v-list>
      <template v-for="(request,index) in requests">
        <v-list-item :key="request.id">
          <v-list-item-content>
            <v-list-item-title v-text="request.id"></v-list-item-title>
          </v-list-item-content>
          <v-btn icon>
            <v-icon color="blue lighten-1">mdi-message</v-icon>
          </v-btn>
        </v-list-item>
        <v-divider v-if="index + 1 < requests.length" :key="index"></v-divider>
      </template>
    </v-list>
  </v-container>
</template>

<script>
import axios from 'axios';
import { mapGetters } from "vuex";

export default {
  data: () => ({
    requests: []
  }),
  computed: mapGetters(['user']),
  created(){
      axios.get(`http://localhost:8090/api/rental/${this.user.id}`).then(response => {
          console.log(response.data);
          this.requests.push(response.data);
      }).catch();
  }
};
</script>

<style>
</style>