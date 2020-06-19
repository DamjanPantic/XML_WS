<template>
  <div>
    <div id="home">
      <navigation v-if="token" />
      <v-container id="container" :class="{loggedUser: token}">
        <router-view></router-view>
      </v-container>
    </div>
  </div>
</template>

<script>
import AppBar from "../components/AppBar.vue";
import Navigation from "../components/Navigation.vue";
import { mapGetters } from "vuex";

export default {
  name: "Home",
  components: {
    AppBar,
    Navigation
  },
  computed: mapGetters(['token'])
};
</script>

<style scoped>
#container {
  height: calc(100vh - 64px);
  width: 100%;
  max-width: 100% !important;
  top: 64px;
  position: fixed;
  overflow: auto;
}

.loggedUser {
  width: calc(100% - 256px) !important;
  left: 256px;
}
</style>