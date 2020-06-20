<template>
  <div id="asd">
    <v-list>
      <template v-for="(item) in allRequests">
        <v-divider  v-bind:key="item.id+100"></v-divider>
        <v-list-item :key="item.id">
          <v-list-item-avatar>
            <v-img src="https://cdn.vuetifyjs.com/images/lists/1.jpg"></v-img>
          </v-list-item-avatar>

          <v-list-item-content>
            <v-list-item-title></v-list-item-title>
            <v-list-item-title v-html="item.issuer.email"></v-list-item-title>
            <v-list-item-title
              v-html="'From: '+  item.fromDate.split('T')[0] +' '+ item.fromDate.split('T')[1].split('.')[0] "
            ></v-list-item-title>
            <v-list-item-title
              v-html="'To: '+  item.toDate.split('T')[0] +' '+ item.toDate.split('T')[1].split('.')[0] "
            ></v-list-item-title>
            <v-list-item-title
              v-html="'Car: '+ item.vehicleBasicDTO.model.manufacturer.name+' '+item.vehicleBasicDTO.model.name "
            ></v-list-item-title>
            <button @click="handleClick(true,item)">accept</button>
            <button @click="handleClick(false,item)">decline</button>
          </v-list-item-content>
        </v-list-item>
      </template>
    </v-list>
  </div>
</template>

<script>
import { mapGetters, mapActions } from "vuex";

export default {
  name: "PendingRequests",
  methods: {
    ...mapActions(["fetchRequests", 'acceptDeclineRequest']),
     async handleClick(accept, item){       
      const approvalObj = {
        approve: accept,
        vehicleId: item.vehicleBasicDTO.id,
        requestId: item.id
      }
      await this.acceptDeclineRequest(approvalObj);
      
    },
    async getRequests() {
      await this.fetchRequests(5);
    },
  },
  computed: mapGetters(["allRequests"]),
  created() {
    this.getRequests();
  }
};
</script>

<style scoped>
#asd {
  position: fixed;
  height: calc(100vh - 64px) !important;
  width: 100%;
  top: 64px !important;
  overflow: scroll !important;
  margin: unset !important;
}
</style>