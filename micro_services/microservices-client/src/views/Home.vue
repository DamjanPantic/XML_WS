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
      axios.get('localhost:8080/vehicle/hello')
      .then(response => {
        alert(response.data)
      })
    }
  }
}
</script>
