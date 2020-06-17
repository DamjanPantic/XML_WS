<template>
  <v-app>
    <Header/>
    <router-view/>
  </v-app>
</template>

<script>
import Header from './components/Header';

export default {
  name: 'App',
  components: {
    Header
  },
  data: () => ({
  }),
};
</script>
