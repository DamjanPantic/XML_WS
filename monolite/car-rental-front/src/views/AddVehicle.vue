<template>
  <v-container>
    <v-row>
      <v-col>
        <v-card>
          <v-card-title>
            <h3>Add Vehicle</h3>
          </v-card-title>
          <v-card-text>
            <v-container>
              <v-row>
                <v-col>
                  <v-select
                    v-model="manufacturer"
                    :items="manufacturers"
                    item-text="name"
                    label="Manufacturer"
                    hint="Pick manufacturer."
                    persistent-hint
                  ></v-select>
                </v-col>
                <v-col>
                  <v-select
                    v-model="vehicle.model"
                    :items="models"
                    item-text="name"
                    label="Model"
                    hint="Pick model."
                    persistent-hint
                    :disabled="models.length == 0"
                  ></v-select>
                </v-col>
              </v-row>
              <v-row>
                <v-col>
                  <v-select
                    v-model="vehicle.fuelType"
                    :items="fuels"
                    item-text="type"
                    label="Fuel"
                    hint="Pick fuel type."
                    persistent-hint
                  ></v-select>
                </v-col>
                <v-col>
                  <v-select
                    v-model="vehicle.transmission"
                    :items="transmissions"
                    item-text="name"
                    label="Transmissions"
                    hint="Pick transmission type."
                    persistent-hint
                  ></v-select>
                </v-col>
                <v-col>
                  <v-select
                    v-model="vehicle.vehicleType"
                    :items="vehicleTypes"
                    item-text="type"
                    label="Vehicle"
                    hint="Pick vehicle type."
                    persistent-hint
                  ></v-select>
                </v-col>
              </v-row>
              <v-row>
                <v-col>
                  <v-text-field
                    v-model="vehicle.traveledKm"
                    label="Mileage"
                    hint="Set milage of vehicle."
                    persistent-hint
                    type="number"
                  ></v-text-field>
                </v-col>
                <v-col>
                  <v-text-field
                    v-model="vehicle.limitKm"
                    label="Milage limit."
                    hint="Set milage limit of vehicle."
                    persistent-hint
                    type="text"
                  ></v-text-field>
                </v-col>
                <v-col>
                  <v-text-field
                    v-model="vehicle.kidsSeatsNo"
                    label="Kids seats number."
                    hint="Set numer of kids seats in vehicle."
                    persistent-hint
                    type="number"
                  ></v-text-field>
                </v-col>
              </v-row>
              <v-row style="margin-top: 2%;" align="center" justify="center">
                <b-card
                  border-variant="secondary"
                  header="Availability"
                  header-border-variant="secondary"
                  align="center"
                >
                  <b-card-text>
                    <v-row align="center" justify="center">
                      <v-col>
                        <v-text-field
                          v-model="availability.place"
                          label="Place"
                          hint="Place of pick up vehicle."
                          persistent-hint
                          type="text"
                        ></v-text-field>
                      </v-col>
                      <v-col>
                        <label>From (date)</label>
                        <datetime format="MM-DD-YYYY H:i" v-model="availability.fromDate"></datetime>
                      </v-col>
                      <v-col>
                        <label>To (date)</label>
                        <datetime format="MM-DD-YYYY H:i" v-model="availability.toDate"></datetime>
                      </v-col>
                      <v-col>
                        <v-btn color="blue" text @click="addAvailability">Add</v-btn>
                      </v-col>
                    </v-row>
                  </b-card-text>
                  <template v-slot:footer v-if="vehicle.availabilities.length !== 0">
                    <div v-for="(availability,index) in vehicle.availabilities" :key="index">
                      <small>{{availability.fromDate}} - {{availability.toDate}} => {{availability.place}}</small>
                      <span
                        style="margin-left: 3%; cursor: pointer;"
                        @click="deleteAvailabbility(index)"
                      >X</span>
                    </div>
                  </template>
                </b-card>
              </v-row>
            </v-container>
          </v-card-text>
          <v-card-actions>
            <v-spacer></v-spacer>
            <v-btn color="red darken-1" text @click="cancel">Cancel</v-btn>
            <v-btn color="green darken-1" text @click="add()">Add</v-btn>
          </v-card-actions>
        </v-card>
      </v-col>
    </v-row>
  </v-container>
</template>

<script>
import datetime from "vuejs-datetimepicker";
import { mapGetters, mapActions } from "vuex";

export default {
  components: {
    datetime
  },
  data: () => ({
    manufacturer: null,
    availability: {
      place: null,
      fromDate: null,
      toDate: null
    },
    vehicle: {
      owner: null,
      model: null,
      transmission: null,
      fuelType: null,
      vehicleType: null,
      traveledKm: null,
      limitKm: null,
      kidsSeatsNo: null,
      cdw: false,
      availabilities: []
    }
  }),
  computed: mapGetters([
    "user",
    "manufacturers",
    "models",
    "fuels",
    "transmissions",
    "vehicleTypes"
  ]),
  watch: {
    manufacturer: function(val) {
      if (val != null) {
        this.getModelFromManufacturerName(val);
      }
    }
  },
  methods: {
    ...mapActions([
      "addVehicle",
      "getDataForAddingVehicle",
      "getModelFromManufacturerName"
    ]),
    add() {
      this.vehicle.model = this.models.filter(x =>
        this.vehicle.model?.includes(x.name)
      )[0];
      this.vehicle.fuelType = this.fuels.filter(x =>
        this.vehicle.fuelType?.includes(x.type)
      )[0];
      this.vehicle.transmission = this.transmissions.filter(x =>
        this.vehicle.transmission?.includes(x.name)
      )[0];
      this.vehicle.vehicleType = this.vehicleTypes.filter(x =>
        this.vehicle.vehicleType?.includes(x.type)
      )[0];
      this.vehicle.owner = this.user;
      this.addVehicle(this.vehicle);
      this.cancel();
    },
    cancel() {
      this.manufacturer = null;
      this.availability = {
        place: null,
        fromDate: null,
        toDate: null
      };
      this.vehicle = {
        model: null,
        transmission: null,
        fuelType: null,
        vehicleType: null,
        traveledKm: null,
        limitKm: null,
        kidsSeatsNo: null,
        cdw: false,
        availabilities: []
      };
    },
    addAvailability() {
      let dateSplited = this.availability.fromDate.split("-");
      this.availability.fromDate =
        this.availability.fromDate.split(" ")[1] +
        " " +
        dateSplited[1] +
        "-" +
        dateSplited[0] +
        "-" +
        dateSplited[2];
      dateSplited = this.availability.toDate.split("-");
      this.availability.toDate =
        this.availability.toDate.split(" ")[1] +
        " " +
        dateSplited[1] +
        "-" +
        dateSplited[0] +
        "-" +
        dateSplited[2];
      this.vehicle.availabilities.push(this.availability);
      this.availability = {
        place: null,
        fromDate: null,
        toDate: null
      };
    },
    deleteAvailabbility(index) {
      this.vehicle.availabilities.splice(index, 1);
    }
  },
  mounted() {
    this.getDataForAddingVehicle();
  }
};
</script>

<style>
/* <v-switch label="AC." v-model="vehicle.ac"></v-switch> */
input[data-v-4bd11526] {
  min-width: unset;
}
</style>