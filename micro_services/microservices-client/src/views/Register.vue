<template>
  <v-card shaped >
    <v-row >
      <v-col cols="8" >
        <div  class="text-left-side-reg">
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
                        v-model="password"
                        id="password"
                        label="Password"
                        name="password"
                        prepend-icon="mdi-lock"
                        type="password"
                    ></v-text-field>
                    <v-text-field
                        v-model="confirm_password"
                        id="confirm_password"
                        label="Confirm Password"
                        name="confirm_password"
                        prepend-icon="mdi-lock"
                        type="password"
                    ></v-text-field>
                    <v-btn type="submit" @click="register"  rounded class="sing-up-btn-reg">Sign up</v-btn>
                </v-form>
            </div>
      </v-col>
      <v-divider vertical/>
        <v-col class="right-side-reg" >
              <div class="right-side-text-reg">
            <p class="display-1 text">Welcome Back!</p>
            <p>To Keep connected with us please login with your personal info</p>
            <v-btn  rounded outlined color="white" @click="goBack">Sign in</v-btn>
          </div>
      </v-col>
    </v-row>
  </v-card>
</template>

<script>
import axios from 'axios';
export default {
    name: 'Register',
    data() {
        return {
            username: '',
            password: '',
            confirm_password: '',
        };
    },
    methods:{
        goBack(){
            this.$router.push('/login');
        },
        register(e){
            e.preventDefault();
            if(this.username === '' || this.password === ''){
                alert("Popunite prazna polja!");
            }else{
            if(this.password !== this.confirm_password){
                alert("Unesene lozinke se razlikuju!")
            }else{
                axios.post(`http://localhost:8080/user/register?username=${this.username}&password=${this.password}`)
                    .then((response) => {
                        alert(response.data);
                        this.$router.push('/');
                    })
                    .catch((error) => {
                        alert(error.response.data);
                    });
            }}
       
        }
    },
}
</script>

<style>
.v-card {
    margin: auto;
    width: 750px;
    height: 450px;
    text-align: center;
}
.row{
    height: 100%;
    width: 100%;
    margin-right: 0px !important;
    margin-left: 0px !important;
}   
.right-side-reg{
    background-color: rgb(27, 151, 233);
    border-radius: 0px 4px 24px 0px;
}
.right-side-text-reg{
    padding: 100px 0px 0px 4px ;
    color: white ; 
  
}
.text-left-side-reg{
    padding: 60px 0px 0px 4px ;
    color:  rgb(27, 151, 233) ;
}
.sing-up-btn-reg{
    background-color: rgb(27, 151, 233) !important;
    color: white !important;  
}
</style>