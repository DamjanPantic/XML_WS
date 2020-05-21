<template>
  <div class="unprotected">
    <h1><b-badge variant="info">Add entity</b-badge></h1>
    <h5></h5>

    <form @submit.prevent="callLogin()">
      <input type="text" placeholder="username" v-model="user">
      <input type="password" placeholder="password" v-model="password">
      <b-btn variant="success" type="submit">Login</b-btn>
      <p v-if="error" class="error">Bad login information</p>
    </form>
  </div>

</template>
<script>
export default {
    
}
</script>

<style scoped>

</style>