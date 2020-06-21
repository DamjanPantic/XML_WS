<template>
  <v-container>
    <v-data-table
      :headers="headers"
      :items="allRequests"
      :sort-desc="[false, true]"
      hide-default-footer
      multi-sort
      class="elevation-1"
    >
      <template v-slot:item.fromDate="{ item }">{{ item.fromDate | dateFormat}}</template>
      <template v-slot:item.toDate="{ item }">{{ item.toDate | dateFormat}}</template>
      <template v-slot:item.actions="{ item }">
        <v-btn
          :to="'/messages/'+ item.owner.username + '/' + item.owner.id + '/' + item.vehicleBasicDTO.model.manufacturer.name + '/' + item.vehicleBasicDTO.model.name +'/'+ item.id"
          icon
          :disabled="item.status !== 'RESERVED'"
        >
          <v-icon color="blue darken-2">mdi-message</v-icon>
        </v-btn>
      </template>
    </v-data-table>
  </v-container>
</template>

<script>
import axios from "axios";
import { mapGetters, mapActions } from "vuex";

export default {
  data: () => ({}),
  computed: {
    ...mapGetters(["user", "allRequests"]),
    headers() {
      let headers;
      if (this.user.username === "Test") {
        headers = [
          { text: "ID", value: "id" },
          { text: "Customer", value: "issuer.username" },
          {
            text: "Manufacturer",
            value: "vehicleBasicDTO.model.manufacturer.name"
          },
          { text: "Model", value: "vehicleBasicDTO.model.name" },
          { text: "From (date)", value: "fromDate" },
          { text: "To (date)", value: "toDate" },
          { text: "Status", value: "status" },
          { text: "Messages", value: "actions", sortable: false }
        ];
      }else{
        headers = [
          { text: "ID", value: "id" },
          { text: "Owner", value: "owner.username" },
          {
            text: "Manufacturer",
            value: "vehicleBasicDTO.model.manufacturer.name"
          },
          { text: "Model", value: "vehicleBasicDTO.model.name" },
          { text: "From (date)", value: "fromDate" },
          { text: "To (date)", value: "toDate" },
          { text: "Status", value: "status" },
          { text: "Messages", value: "actions", sortable: false }
        ];
      }

      return headers;
    }
  },
  methods: {
    ...mapActions(["userRentalRequest"])
  },
  filters: {
    dateFormat: function(value) {
      if (!value) return "";
      value = value.split("T")[0] + " " + value.split("T")[1].split(".")[0];
      return value;
    }
  },
  created() {
    this.userRentalRequest(this.user);
  }
};
</script>

<style scoped>
.v-dialog {
  position: absolute;
  bottom: 0;
  right: 0;
}
</style>