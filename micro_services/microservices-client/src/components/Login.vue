<template>
  <form class="login-form">
    <v-text-field
        v-model="username"
        label="Username"
        required
        @input="$v.email.$touch()"
        @blur="$v.email.$touch()"
    ></v-text-field>
    <v-text-field
        v-model="password"
        :type="show1 ? 'text' : 'password'"
        name="input-10-1"
        label="Password"
        counter
        @click:append="show1 = !show1"
    ></v-text-field>

    <v-btn class="mr-4" @click="onLoginFormSubmit">submit</v-btn>
    <v-btn @click="clear">clear</v-btn>
  </form>
</template>

<script>
  import { validationMixin } from 'vuelidate'
  import { required, maxLength, email } from 'vuelidate/lib/validators'
  import { mapGetters, mapActions } from 'vuex'
  export default {
    mixins: [validationMixin],
    validations: {
        email: { required, email },
        checkbox: {
            checked (val) {
            return val
            },
        },
    },
    data: () => ({
        username: '',
        password: '',
        show1: false,
        checkbox: false,
        rules: {
            required: value => !!value || 'Required.',
            min: v => v.length >= 8 || 'Min 8 characters',
        },
      
    }),
    computed: {
        checkboxErrors () {
            const errors = []
            if (!this.$v.checkbox.$dirty) return errors
            !this.$v.checkbox.checked && errors.push('You must agree to continue!')
            return errors
      },
        selectErrors () {
            const errors = []
            if (!this.$v.select.$dirty) return errors
            !this.$v.select.required && errors.push('Item is required')
            return errors
      },
        nameErrors () {
            const errors = []
            if (!this.$v.name.$dirty) return errors
            !this.$v.name.maxLength && errors.push('Name must be at most 10 characters long')
            !this.$v.name.required && errors.push('Name is required.')
            return errors
      },
        emailErrors () {
            const errors = []
            if (!this.$v.email.$dirty) return errors
            !this.$v.email.email && errors.push('Must be valid e-mail')
            !this.$v.email.required && errors.push('E-mail is required')
            return errors
      },
    },
    methods: {
      ...mapActions(['loginUser']),
      async onLoginFormSubmit() {            
        const userObj = {
          username: this.username,
          password: this.password
        }
          await this.loginUser(userObj);                        
          this.$router.push('/movies');
        },
        computed: mapGetters(['token', 'user']),
      
      submit () {
        this.$v.$touch()
      },
      clear () {
        this.$v.$reset()
        this.email = ''
        this.password=''
      },
    },
  }
</script>

<style>
    .login-form{
        width: 70%;
        margin-left: 25%;
    }
    @media (max-width: 500px) {
        .login-form{
        width: 90%;
        margin-left: 5%;
    }
    }
</style>