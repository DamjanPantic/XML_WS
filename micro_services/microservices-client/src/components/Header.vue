<template>
  <div>
    <v-toolbar
      dark
      prominent
      src="https://www.zim-rentacar.com/images/rent-a-car-beograd-zim-cover/rent-a-car-beograd-opel-astra-zim-cover.jpg"
    >  
      <v-app-bar-nav-icon @click="showDrawer =  !showDrawer"></v-app-bar-nav-icon>

      <v-toolbar-title>Pocket</v-toolbar-title>

      <v-spacer></v-spacer>

      <v-btn icon>
        <v-icon>mdi-export</v-icon>
      </v-btn>
    </v-toolbar>
    <v-navigation-drawer v-model="showDrawer" app  disable-resize-watcher>
        <v-list-item>
            <v-list-item-content>
                <v-list-item-title class="title">
                    Application
                </v-list-item-title>
                <v-list-item-subtitle>
                    subtext
                </v-list-item-subtitle>
            </v-list-item-content>
        </v-list-item>

      <v-divider></v-divider>
    </v-navigation-drawer>

        <v-select
          v-model="genre"
          :items="allGenres" item-value="name" item-text="name"
          label="Filter movies"
          @input="filterMovies"
          required
        ></v-select>
  </div>
</template>
<script>
import { mapGetters, mapActions } from 'vuex';
import routeNames from '../router/router-names';

export default {
    name: 'Header',
    data(){
        return{
            showDrawer: false,
            items: [
            { title: 'Login', icon: 'mdi-login', path: '/login' },
            { title: 'Home', icon: 'mdi-login', path: '/'}
            ],
            right: null,
            routeNames,
            genre: null
        }
    }
}
</script>

<style scoped>

</style>