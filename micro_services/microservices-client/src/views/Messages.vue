<template>
  <div>
    <v-row>
      <v-col align="center">
        <v-toolbar width="72%" color="blue darken-2 white--text" class="mb-2">
          <v-toolbar-title>Discover</v-toolbar-title>
        </v-toolbar>
        <v-card id="messages" outlined max-width="72%">
          <v-row style="height: unset !important;">
            <v-col cols="12" v-for="message in messages" :key="message.id">
              <v-card
                class="tooltip"
                :class="[{myMessage: message.senderId === user.id}, {recievedMessage: message.senderId !== user.id}, {tooltipMy: message.senderId === user.id}, {tooltipHis: message.senderId !== user.id}]"
                max-width="45%"
              >
                <v-card-title>
                  <span class="title font-weight-bold">{{message.subject}}</span>
                </v-card-title>

                <v-card-text
                  class="font-weight-bold myMessageText"
                  :class="[{myMessageText: message.senderId === user.id}, {recievedMessageText: message.senderId !== user.id}]"
                >{{ message.content }}</v-card-text>
                <span class="tooltiptextMy tooltiptext">{{ message.sendDate | dateFormat }}</span>
              </v-card>
            </v-col>
          </v-row>
        </v-card>
      </v-col>
    </v-row>
    <v-row>
      <v-col align="center" class="subject">
        <v-text-field v-model="subject" label="Subject" outlined style="width: 72%;" dense></v-text-field>
      </v-col>
    </v-row>
    <v-row>
      <v-col align="center" class="message">
        <v-textarea v-model="message" style="width: 72%;" outlined label="Message...."></v-textarea>
        <v-btn
          id="sendBtn"
          color="blue darken-2 white--text"
          @click="sendRequestMessage"
        >Send Message</v-btn>
      </v-col>
    </v-row>
  </div>
</template>

<script>
import { mapGetters, mapActions } from "vuex";

export default {
  data: () => ({
    subject: "",
    message: ""
  }),
  computed: {
    ...mapGetters(["messages", "user"])
  },
  methods: {
    ...mapActions(["sendMessage", "getRequestConversation"]),
    async sendRequestMessage() {
      let message = {
        subject: this.subject,
        content: this.message,
        requestId: this.$route.params.requestId,
        senderId: this.user.id,
        receiverId: this.$route.params.ownerId
      };
      await this.sendMessage(message);
      this.subject = "";
      this.message = "";
      var objDiv = document.getElementById("messages");
      objDiv.scrollTop = objDiv.scrollHeight;
    }
  },
  filters: {
    dateFormat: function(value) {
      if (!value) return "";
      value = value.split(".")[0];
      return value;
    }
  },
  created() {
    this.getRequestConversation(this.$route.params.requestId);
  },
  mounted() {
    var objDiv = document.getElementById("messages");
    objDiv.scrollTop = objDiv.scrollHeight;
  }
};
</script>

<style scoped>
#messages {
  overflow: auto;
}
#sendBtn {
  width: 72%;
}

.subject {
  padding-bottom: 0%;
}

.message {
  padding-top: 0%;
}

.myMessage {
  background-color: rgb(100, 181, 246) !important;
  float: right;
  height: unset !important;
  margin-right: 4%;
  color: white !important;
}

.myMessageText {
  color: white !important;
}

.recievedMessage {
  background-color: rgb(219, 222, 224) !important;
  float: left;
  height: unset !important;
  margin-left: 4%;
  color: black !important;
}

.recievedMessageText {
  color: black !important;
}

.tooltip {
  position: relative;
  display: inline-block;
}

.tooltiptext {
  visibility: hidden;
}

.tooltipMy .tooltiptextMy {
  width: 120px;
  background-color: rgb(100, 181, 246);
  color: white;
  text-align: center;
  border-radius: 6px;
  padding: 5px 0;

  /* Position the tooltip */
}

.tooltipHis .tooltiptextHis {
  visibility: hidden;
  width: 120px;
  background-color: rgb(219, 222, 224);
  color: black;
  text-align: center;
  border-radius: 6px;
  padding: 5px 0;

  /* Position the tooltip */
}

.tooltip:hover .tooltiptext {
  visibility: visible;
}
</style>