<template>
  <div class="home">
    <button @click="clickas">asd</button>
  </div>
</template>

<script>
import axios from 'axios';

export default {
  name: 'Home',
  methods:{
    clickas(){
      console.log('asd')
      axios.get('email/hello')
      .then(response => {
        alert(response.data)
      })
    }
  }
}
</script>
