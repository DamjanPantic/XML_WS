<template>
  <v-app-bar class="appBar" color="blue darken-2 white--text">
    <router-link to="/home" class="homeBtn" tag="v-toolbar-title">Car rental</router-link>

    <router-link class="signInBtn" to="/login" tag="v-toolbar-title">Sign in</router-link>
  </v-app-bar>
</template>

<script>
export default {
  name: "AppBar",
  methods: {}
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
      flex-basis: 100%;
      text-align: right;
          margin-right: 1.75em ;

}
.homeBtn{
    width: 100%;
              margin-left: 1.75em ;

}
</style>