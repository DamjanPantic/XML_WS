<template>
  <v-app>
    <app-bar />
    <router-view></router-view>
  </v-app>
</template>

<script>
import AppBar from "./components/AppBar.vue";
export default {
  name: "App",
  components: {
    AppBar
  }
};
</script>
<style>
html {
  overflow: hidden !important;
}
</style>