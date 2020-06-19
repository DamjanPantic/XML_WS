<template>
  <v-app>
    <app-bar />
    <router-view></router-view>
  </v-app>
</template>

<script>
import AppBar from "./components/AppBar.vue";
import { mapActions } from "vuex";

export default {
  name: "App",
  components: {
    AppBar
  },
  methods: {
    ...mapActions(['refreshUser']),
  },
  created(){
    if (localStorage.getItem('token')) {
      this.refreshUser(localStorage.getItem('token'));
    }
  }
};
</script>
<style>
html {
  overflow: hidden !important;
}
</style>