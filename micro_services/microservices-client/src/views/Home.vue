<template>
  <div>
    <div id="home">
      <navigation v-if="this.$store.getters.token != null"/>
      <div id="container">
          <router-view></router-view>
      </div>
    </div>
  </div>
</template>

<script>
import AppBar from "../components/AppBar.vue";
import Navigation from "../components/Navigation.vue";
export default {
  name: "Home",
  components: {
    AppBar,
    Navigation
  }
};
</script>

<style scoped>
#container {
  max-height: calc(100vh - 64px);
  width: calc(100% - 256px);
  left: 256px;
  top: 64px;
  position: fixed;
  overflow: auto;
}
</style>