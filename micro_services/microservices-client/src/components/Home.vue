<template>
  <div>
    <input type="file" ref="imageInput" multiple @change="changeInput" />
    <div v-for="(u,i) in urls" v-bind:key="i">
      <img :src="u.asd" height="100px" width="150px" />
    </div>

    <button @click="submit">submit</button>
    <button @click="getvehicle">getvehicle</button>
     <div v-for="(u,i) in vehicles" v-bind:key="i">
      <img v-for="(imgs, ix) in u.images" :key="ix+10" :src="imgs.asd" height="100px" width="150px" />
    </div>
  </div>
</template>

<script>
import axios from "axios";

export default {
  name: "Home",
  data() {
    return {
      url: "",
      urls: [],
      vehicles: ''
    };
  },

  methods: {
    submit() {
      axios
        .post("vehicle", {
          limitKm: "cxv",
          cdw: true,
          owner: {
            id: 2,
            email: "mail1@mail.com",
            username: "mile1"
          },
          features: [
            {
              id: 1,
              value: "DISEL",
              type: {
                id: 1,
                name: "FUEL"
              }
            }
          ],
          model: {
            id: 1,
            name: "911",
            manufacturer: {
              id: 1,
              name: "Porshe"
            }
          },
          images: this.urls
        })
        .then(response => {
          alert(response.data);
        });
    },
    changeInput(e) {
      const image = e.target.files[0];
      const reader = new FileReader();
      reader.readAsDataURL(image);
      reader.onload = e => {
        this.previewImage = e.target.result;
        this.urls.push({asd: this.previewImage});
        this.$refs.imageInput.value = "";
      };
    },
    getvehicle(){
      axios.get('vehicle/get')
      .then(response => {
        console.log(response.data)
          this.vehicles=response.data;

      })
    }
  }
};
</script>

<style>
</style>
