<template>
  <div>
    <h1>Comments</h1>
    <v-simple-table>
      <template>
        <thead>
          <tr>
            <th class="text-left">Sender</th>
            <th class="text-left">Vehicle ID</th>
            <th class="text-left">Vehicle</th>
            <th class="text-left">Content</th>
          </tr>
        </thead>
        <tbody>
          <tr v-for="c in comments" :key="c.id">
            <td>{{c.user.username}}</td>
            <td>{{c.vehicle.id}}</td>
            <td>{{c.vehicle.model.manufacturer.name}} {{c.vehicle.model.name}}</td>
            <td>{{c.content}}</td>
          </tr>
        </tbody>
      </template>
    </v-simple-table>
  </div>
</template>

<script>
import { mapGetters, mapActions } from "vuex";

export default {
  name: "CommentsList",
  computed: {
    ...mapGetters(["comments", "user"])
  },
  methods: {
    ...mapActions(["fetchComments"])
  },
  created() {
    this.fetchComments(this.user.id);
  }
};
</script>

<style scoped>
</style>