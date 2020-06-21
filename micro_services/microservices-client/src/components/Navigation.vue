<template>
  <v-navigation-drawer class="navigation" permanent left>
    <template v-slot:prepend>
      <v-list-item two-line>
        <v-list-item-avatar size="50">
          <img src="https://randomuser.me/api/portraits/men/81.jpg" />
        </v-list-item-avatar>

        <v-list-item-content>
          <v-list-item-title>{{user.username}}</v-list-item-title>
          <v-list-item-subtitle>Logged In</v-list-item-subtitle>
        </v-list-item-content>
      </v-list-item>
    </template>

    <v-divider></v-divider>

    <v-list>
      <v-list-item link to="/">
        <v-list-item-icon>
          <v-icon>mdi-home</v-icon>
        </v-list-item-icon>

        <v-list-item-content>
          <v-list-item-title>Home</v-list-item-title>
        </v-list-item-content>
      </v-list-item>

      <v-list-item link :to="'/user-requests/'+user.id">
        <v-list-item-icon>
          <v-icon>mdi-message</v-icon>
        </v-list-item-icon>

        <v-list-item-content>
          <v-list-item-title>Requests messagener</v-list-item-title>
        </v-list-item-content>
      </v-list-item>

      <v-list-item link :to="'/requests'" v-if="user!== null">
        <v-list-item-icon>
          <v-icon>mdi-view-list</v-icon>
        </v-list-item-icon>

        <v-list-item-content>
          <v-list-item-title>Pending requests</v-list-item-title>
        </v-list-item-content>
      </v-list-item>

      <v-list-item link :to="'/cart'">
        <v-list-item-icon>
          <v-icon>mdi-cart</v-icon>
        </v-list-item-icon>
        <v-list-item-content>
          <v-list-item-title v-if="getCartItemsNumber !== 0">{{getCartItemsNumber}} </v-list-item-title>
        </v-list-item-content>
      </v-list-item>

      <v-list-item link :to="'/reserved'">
        <v-list-item-icon>
          <v-icon>mdi-cart</v-icon>
        </v-list-item-icon>
        <v-list-item-content>
          <v-list-item-title >Reserved  </v-list-item-title>
        </v-list-item-content>
      </v-list-item>

    </v-list>
    <template v-slot:append>
      <div class="pa-2">
        <v-btn @click="logout" block color="blue white--text">Logout</v-btn>
      </div>
    </template>
  </v-navigation-drawer>
</template>

<script>
import { mapGetters, mapActions, user } from "vuex";

export default {
  name: "Navigation",
  computed: mapGetters(["user", "getCartItemsNumber"]),
  methods: {
    ...mapActions(["logoutUser"]),
    logout() {
      this.logoutUser();
      if (this.$router.currentRoute.path !== "/") {
        this.$router.push("/");
      }
    }
  }
};
</script>

<style>
.icon-style {
  display: unset !important;
  width: 24px;
}
.navigation {
  z-index: 10000;
  position: fixed;
  top: 64px !important;
  height: calc(100% - 64px) !important;
}
</style>