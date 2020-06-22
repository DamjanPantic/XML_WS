<template>
  <v-app-bar app color="yellow darken-1" dark>
    <router-link to="/" tag="h2" style="cursor: pointer;">Monolite</router-link>
    <v-spacer></v-spacer>
    <template v-if="user != null">
      <v-menu left bottom>
        <template v-slot:activator="{ on, attrs }">
          <v-btn icon v-bind="attrs" v-on="on">
            <v-icon>mdi-dots-vertical</v-icon>
          </v-btn>
        </template>

        <v-list>
          <v-list-item to="/add-vehicle">
            <v-list-item-title>
              <v-icon>Vehicle</v-icon>
              <v-icon class="ml-3">mdi-car-3-plus</v-icon>
            </v-list-item-title>
          </v-list-item>
          <v-divider></v-divider>
          <v-list-item to="/grades">
            <v-list-item-title>
              <v-icon>Rating</v-icon>
              <v-icon class="ml-3">mdi-thumb-up</v-icon>
            </v-list-item-title>
          </v-list-item>
          <v-divider></v-divider>
             <v-list-item to="/comments">
            <v-list-item-title>
              <v-icon>Comments</v-icon>
              <v-icon class="ml-3">mdi-comment-text-outline</v-icon>
            </v-list-item-title>
          </v-list-item>
          <v-divider></v-divider>
          <v-list-item @click="logoutUser">
            <v-list-item-title>
              <v-icon>Logout</v-icon>
            </v-list-item-title>
          </v-list-item>
        </v-list>
      </v-menu>
    </template>
    <template v-else>
      <router-link to="/login" tag="h5" style="cursor: pointer; margin-right: 2%;">Login</router-link>
      <router-link to="/register" tag="h5" style="cursor: pointer;">Register</router-link>
    </template>
  </v-app-bar>
</template>

<script>
import { mapGetters, mapActions } from "vuex";

export default {
  computed: mapGetters(["user"]),
  methods: {
    ...mapActions(["logoutUser"])
  }
};
</script>

<style>
</style>