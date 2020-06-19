<template>
  <v-card shaped>
    <v-row>
      <v-col class="left-side">
        <div class="text-left-side">
          <p class="display-1 text">Hello, Friend!</p>
          <p>Enter your personal details and start journay with us</p>
          <v-btn rounded outlined color="white" @click="toRegister">Sign up</v-btn>
        </div>
      </v-col>
      <v-divider vertical />
      <v-col cols="8">
        <div class="right-side-text">
          <p class="display-1 text">Sing in to Car Rental App!</p>
          <v-form>
            <v-text-field
              v-model="username"
              label="Username"
              name="username"
              prepend-icon="mdi-account"
              type="text"
            ></v-text-field>

            <v-text-field
              v-model="password"
              id="password"
              label="Password"
              name="password"
              prepend-icon="mdi-lock"
              type="password"
            ></v-text-field>
            <v-btn rounded class="sing-in-btn" @click="toLogin">Sign in</v-btn>
          </v-form>
        </div>
      </v-col>
    </v-row>
  </v-card>
</template>

<script>
import axios from "axios";
import { mapGetters, mapActions } from "vuex";

export default {
  name: "Login",
  data() {
    return {
      username: "",
      password: ""
    };
  },
  methods: {
    ...mapActions(["loginUser"]),
    toRegister() {
      this.$router.push("/register");
    },
    toLogin() {
      let user = { username: this.username, password: this.password };
      const options = {
        headers: {
          "Access-Control-Allow-Origin": "*"
        }
      };
      axios
        .post("http://localhost:8080/api/auth/login", user, options)
        .then(response => {
          console.log(response);
        })
        .catch();
      this.$router.push("/");
    }
  }
};
</script>

<style>
.v-card {
  margin: auto;
  width: 750px;
  height: 450px;
  text-align: center;
}
.row {
  height: 100%;
  width: 100%;
  margin-right: 0px !important;
  margin-left: 0px !important;
}
.left-side {
  background-color: rgb(27, 151, 233);
  border-radius: 24px 0px 0px 4px;
}
.right-side-text {
  padding: 80px 0px 0px 4px;
  color: rgb(27, 151, 233);
}
.text-left-side {
  padding: 100px 0px 0px 4px;
  color: white;
}
.sing-in-btn {
  background-color: rgb(27, 151, 233) !important;
  color: white !important;
}
</style>