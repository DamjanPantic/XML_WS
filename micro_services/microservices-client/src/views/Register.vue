<template>
  <v-card shaped>
    <v-row>
      <v-col cols="8">
        <div class="text-left-side-reg">
          <p class="display-1 text">Create Account!</p>
          <v-form>
            <v-text-field
              v-model="username"
              label="Username"
              name="username"
              prepend-icon="mdi-account"
              type="text"
            ></v-text-field>
            <v-text-field
              v-model="email"
              label="Email"
              name="email"
              prepend-icon="mdi-email"
              type="email"
            ></v-text-field>
            <v-text-field
              v-model="password"
              prepend-icon="mdi-lock"
              :append-icon="show1 ? 'mdi-eye' : 'mdi-eye-off'"
              :rules="[rules.required, rules.uppercase, rules.min, rules.containsNumber, rules.specialChar]"
              :type="show1 ? 'text' : 'password'"
              name="input-10-1"
              label="Password"
              hint="At least 10 characters"
              counter
              @click:append="show1 = !show1"
          ></v-text-field>
            <v-text-field
              v-model="confirm_password"
              id="confirm_password"
              label="Confirm Password"
              name="confirm_password"
              prepend-icon="mdi-lock"
              type="password"
            ></v-text-field>
            <v-btn type="submit" @click="register" rounded class="sing-up-btn-reg">Sign up</v-btn>
          </v-form>
        </div>
      </v-col>
      <v-divider vertical />
      <v-col class="right-side-reg">
        <div class="right-side-text-reg">
          <p class="display-1 text">Welcome Back!</p>
          <p>To Keep connected with us please login with your personal info</p>
          <v-btn rounded outlined color="white" @click="goBack">Sign in</v-btn>
        </div>
      </v-col>
    </v-row>
  </v-card>
</template>

<script>
import axios from "axios";
import { mapActions } from "vuex";

export default {
  name: "Register",
  data() {
    return {
      username: "",
      password: "",
      email: "",
      confirm_password: "",
      format: /[ `!@#$%^&*()_+\-=\[\]{};':"\\|,.<>\/?~]/,
      show1: false,
      rules: {
          required: value => !!value || 'Required.',
          uppercase: v => (/[a-z]/.test(v)) || "Must have uppercase",
          min: v => v.length >= 10 || 'Min 10 characters',
          containsNumber: v => /\d/.test(v) || 'Must have number',
          specialChar: v => this.format.test(v) || "Must have special character",
          emailMatch: () => ('The email and password you entered don\'t match'),
        },
    };
  },
  methods: {
    ...mapActions(["registerUser"]),
    goBack() {
      this.$router.push("/login");
    },
    register(e) {
      e.preventDefault();
      let user = {username: this.username, email: this.email, password: this.password};
      this.registerUser(user);
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
.right-side-reg {
  background-color: rgb(27, 151, 233);
  border-radius: 0px 4px 24px 0px;
}
.right-side-text-reg {
  padding: 100px 0px 0px 4px;
  color: white;
}
.text-left-side-reg {
  padding: 60px 0px 0px 4px;
  color: rgb(27, 151, 233);
}
.sing-up-btn-reg {
  background-color: rgb(27, 151, 233) !important;
  color: white !important;
}
</style>