<template>
  <v-app-bar class="appBar" color="blue darken-2 white--text">
    <router-link to="/" class="homeBtn" tag="v-toolbar-title">Car rental</router-link>
    <v-spacer/>
    <router-link class="signInBtn" to="/login" tag="v-toolbar-title" v-if="!token">Sign in</router-link>
  </v-app-bar>
</template>

<script>
import { mapGetters } from "vuex";
export default {
  name: "AppBar",
  computed: mapGetters(['token']),
};
</script>

<style>
.appBar {
  z-index: 10000;
  position: fixed;
  display: flex;
  flex-direction: row;
  top: 0;
  width: 100%;
}
.signInBtn {
  margin-right: 1.75em;
  cursor: pointer;
}
.homeBtn {
  margin-left: 1.75em;
  cursor: pointer;
}
</style>