<template>
  <div id="reservedReq">
    <v-list>
      <template v-for="(item) in getReservedRequests">
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
            <v-list-item-title v-if="item.vehicleBasicDTO !== null"
              v-html="'Car: '+ item.vehicleBasicDTO.model.manufacturer.name+' '+item.vehicleBasicDTO.model.name "
            ></v-list-item-title>
            <button @click="handleClick(true,item)">pay</button>
          </v-list-item-content>
        </v-list-item>
      </template>
    </v-list>
  </div>
</template>

<script>
import { mapGetters, mapActions } from "vuex";

export default {
  name: "ReservedRequests",
  methods: {
    ...mapActions(["fetchReservedRequests", 'proceedPayment']),
        async handleClick(accept, item){       
      
        console.log("pay", item.id);
        this.proceedPayment(item);
        this.$router.push(`/payment/${item.id}`);
      
    },
    async getRequests() {
      await this.fetchReservedRequests(this.user.id);
    },
  },
  computed: mapGetters(["getReservedRequests", "user"]),
  created() {
    this.getRequests();
  }
};
</script>

<style scoped>
#reservedReq {
  position: fixed;
  height: calc(100vh - 64px) !important;
  width: 100%;
  top: 64px !important;
  overflow: scroll !important;
  margin: unset !important;
}
</style>