<template>
  <v-simple-table>
    <template>
      <thead>
        <tr>
          <th class="text-left">Sender</th>
          <th class="text-left">Vehicle ID</th>
          <th class="text-left">Vehicle</th>
          <th class="text-left">Content</th>
          <th class="text-left"></th>
        </tr>
      </thead>
      <tbody>
        <tr v-for="c in comments" :key="c.id">
          <td>{{c.userId.username}}</td>
          <td>{{c.vehicleId.id}}</td>
          <td>{{c.vehicleId.model.manufacturer.name}} {{c.vehicleId.model.name}}</td>
          <td>{{c.content}}</td>
          <td>
            <v-btn class="ma-2" small outlined fab color="green" @click="approve(c.id)">
              <v-icon>mdi-check</v-icon>
            </v-btn>
            <v-btn class="ma-2" small outlined fab color="red" @click="decline(c.id)">
              <v-icon>mdi-close</v-icon>
            </v-btn>
          </td>
        </tr>
      </tbody>
    </template>
  </v-simple-table>
</template>

<script>
import { mapGetters, mapActions } from "vuex";

export default {
  name: "PendingCommentsList",
  computed: {
    ...mapGetters(["comments"])
  },
  methods: {
    ...mapActions(["fetchComments"]),
    decline(id){

    },
    approve(id){

    },
  },
  created() {
    this.fetchComments();
  }
};
</script>

<style scoped>
</style>