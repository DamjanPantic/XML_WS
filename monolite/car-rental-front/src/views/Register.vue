<template>
  <v-row>
    <v-col align="center" justify="center">
      <v-container>
        <v-card>
          <v-card-title>
            <h3>Register</h3>
          </v-card-title>
          <v-card-text>
            <v-row>
              <v-col cols="12">
                <v-text-field v-model="user.username" label="Username" type="text"></v-text-field>
              </v-col>
              <v-col cols="12">
                <v-text-field v-model="user.email" label="E-mail" type="email"></v-text-field>
              </v-col>
              <v-col cols="12">
                <v-text-field v-model="user.password" label="Password" type="password"></v-text-field>
              </v-col>
            </v-row>
            <v-row>
              <v-col>
                <v-btn color="green white--text" @click="register">Register</v-btn>
              </v-col>
            </v-row>
          </v-card-text>
        </v-card>
      </v-container>
    </v-col>
  </v-row>
</template>

<script>
import { mapGetters, mapActions } from "vuex";

export default {
  data: () => ({
    user: {
      username: null,
      email: null,
      password: null
    }
  }),
  methods: {
    ...mapActions(['registerUser']),
    register(){
      this.registerUser(this.user);
    }
  }
};
</script>

<style>
</style>