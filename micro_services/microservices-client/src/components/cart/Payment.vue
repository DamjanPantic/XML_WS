<template>
<div>
  <v-list-item-content>
            <v-list-item-title></v-list-item-title>
            <v-list-item-title v-html="getRequest.issuer.email"></v-list-item-title>
            <v-list-item-title
              v-html="'From: '+  getRequest.fromDate.split('T')[0] +' '+ getRequest.fromDate.split('T')[1].split('.')[0] "
            ></v-list-item-title>
            <v-list-item-title
              v-html="'To: '+  getRequest.toDate.split('T')[0] +' '+ getRequest.toDate.split('T')[1].split('.')[0] "
            ></v-list-item-title>
            <v-list-item-title v-if="getRequest.vehicleBasicDTO !== null"
              v-html="'Car: '+ getRequest.vehicleBasicDTO.model.manufacturer.name+' '+getRequest.vehicleBasicDTO.model.name "
            ></v-list-item-title>
            <v-list-item-title v-if="getRequest.vehicleBasicDTO !== null"
              v-html="'Final price: 100$' "
            ></v-list-item-title>
            <div class="my-2">
            <v-btn x-large color="success" dark @click="payReq(getRequest)">Continue payment</v-btn>
          </div>
      </v-list-item-content>
</div>
</template>
 
<script>
import { mapGetters, mapActions } from "vuex";
 
export default {
  methods: {
    ...mapActions(['pay']),
    async payReq(request){
      console.log(request);
      await this.pay(request.id);
      alert("Payment completed");
      this.$router.push("/reserved");
      
    }
  },
  computed: mapGetters(["getRequest", "user"]),
  created() {
    console.log(this.$route.params.id);
  }
  
}
</script> 
 
<style>

</style> 