<template>
<div>
    <h1>Grades</h1>
  <v-simple-table>
    <template>
      <thead>
        <tr>
          <th class="text-left">Sender</th>
          <th class="text-left">Vehicle ID</th>
          <th class="text-left">asd</th>
          <th class="text-left">Content</th>
          <th class="text-left"></th>
        </tr>
      </thead>
      <tbody>
     
          <tr v-for="g in grades" :key="g.id">
            <td>{{g.user.username}}</td>
            <td>{{g.vehicle.id}}</td>
            <td>{{g.vehicle.model.manufacturer.name}} {{g.vehicle.model.name}}</td>
            <td>{{g.gradeValue}}</td>
          </tr>
        </tbody>
    </template>
  </v-simple-table>
</div>
</template>

<script>
import { mapGetters, mapActions } from "vuex";

    export default {
        name: "GradeList",
          computed: {
    ...mapGetters(["grades", "user"])
  },
  methods: {
    ...mapActions(["fetchGrades"])
  },
  created() {
    this.fetchGrades(this.user.id);
  }
    }
</script>

<style scoped>

</style>