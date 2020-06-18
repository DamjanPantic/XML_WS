<template>
  <v-col cols="4">
    <v-row justify="center">
      <v-card loading="true" height="100%">
        <v-img src="https://cdn.vuetifyjs.com/images/cards/cooking.png"></v-img>

        <v-card-title>Cafe Badilico</v-card-title>

        <v-card-text>
          <v-row align="center" class="mx-0">
            <v-rating :value="4.5" color="amber" dense half-increments readonly size="14"></v-rating>

            <div class="grey--text ml-4">4.5 (413)</div>
          </v-row>

          <div class="my-4 subtitle-1">$ • Italian, Cafe</div>

          <div>Small plates, salads & sandwiches - an intimate setting with 12 indoor seats plus patio seating.</div>
        </v-card-text>

        <v-card-actions>
          <v-btn color="blue darken-2" text left>Info</v-btn>
          <v-spacer />
          <v-btn icon color="red" right>
            <v-icon>mdi-heart-outline</v-icon>
          </v-btn>
        </v-card-actions>
      </v-card>
    </v-row>
  </v-col>
</template>

<script>
export default {};
</script>

<style>
</style>