<template>
  <div id="asd">
    <v-list>
      <template v-for="(item, index) in allRequests">
        <v-divider v-bind="index" />
        <v-list-item :key="item.issuer.email">
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
            <button>accept</button>
            <button>decline</button>
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
    ...mapActions(["fetchRequests"]),
    async getRequests() {
      console.log("get requests");

      await this.fetchRequests(5);
    }
  },
  data: () => ({
    items: [
      { header: "Today" },
      {
        avatar: "https://cdn.vuetifyjs.com/images/lists/1.jpg",
        title: "Brunch this weekend?",
        subtitle:
          "<span class='text--primary'>Ali Connors</span> &mdash; I'll be in your neighborhood doing errands this weekend. Do you want to hang out?"
      },
      { divider: true, inset: true },
      {
        avatar: "https://cdn.vuetifyjs.com/images/lists/2.jpg",
        title: 'Summer BBQ <span class="grey--text text--lighten-1">4</span>',
        subtitle:
          "<span class='text--primary'>to Alex, Scott, Jennifer</span> &mdash; Wish I could come, but I'm out of town this weekend."
      },
      { divider: true, inset: true },
      {
        avatar: "https://cdn.vuetifyjs.com/images/lists/3.jpg",
        title: "Oui oui",
        subtitle:
          "<span class='text--primary'>Sandra Adams</span> &mdash; Do you have Paris recommendations? Have you ever been?"
      },
      { divider: true, inset: true },
      {
        avatar: "https://cdn.vuetifyjs.com/images/lists/4.jpg",
        title: "Birthday gift",
        subtitle:
          "<span class='text--primary'>Trevor Hansen</span> &mdash; Have any ideas about what we should get Heidi for her birthday?"
      },
      { divider: true, inset: true },
      {
        avatar: "https://cdn.vuetifyjs.com/images/lists/5.jpg",
        title: "Recipe to try",
        subtitle:
          "<span class='text--primary'>Britta Holt</span> &mdash; We should eat this: Grate, Squash, Corn, and tomatillo Tacos."
      }
    ]
  }),
  computed: mapGetters(["allRequests"]),
  created() {
    console.log("created");

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