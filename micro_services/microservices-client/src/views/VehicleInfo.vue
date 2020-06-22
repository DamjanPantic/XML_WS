<template>
  <v-container>
    <v-row>
      <v-col align="center" cols="12" v-for="comment in comments" :key="comment.id">
        <v-card width="72%" height="100%" outlined>
          <v-row justify="center">
            <v-col cols="2" align="start">
              <b>{{comment.userId.username}}:</b>
            </v-col>
            <v-col cols="9" align="start">
              <small>{{comment.content}}</small>
            </v-col>
          </v-row>
        </v-card>
      </v-col>
    </v-row>
    <v-row>
      <v-col align="center" cols="12" style="padding-top: 0%;">
        <v-textarea v-model="comment.content" style="width: 72%;" outlined label="Comment...."></v-textarea>
        <v-btn color="yellow darken-2 white--text" @click="addCommentToVehicle">Add comment</v-btn>
      </v-col>
    </v-row>
  </v-container>
</template>

<script>
import { mapGetters, mapActions } from "vuex";

import { ServiceFactory } from '../services/ServiceFactory';

export default {
  data: () => ({
    comment: {
      content: null,
      vehicleId: null,
      userId: null
    },
    comments: []
  }),
  computed: mapGetters(["user", "vehicles"]),
  methods: {
    ...mapActions(["addComment"]),
    addCommentToVehicle() {
      this.comment.userId = this.user.id;
      this.comment.vehicleId = Number.parseInt(this.$route.params.id);
      this.addComment(this.comment);
    }
  },
  mounted() {
      const recensionService = ServiceFactory.get('recension');

      let response = recensionService.getVehicleComments(Number.parseInt(this.$route.params.id));

      response.then(comments => {
          this.comments = comments.data;
      })
  }
};
</script>

<style>
</style>