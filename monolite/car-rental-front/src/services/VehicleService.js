import Service from './Service';

const resource = '/vehicle';

class VehicleService extends Service{
    addVehicle(vehicle) {
        return this.getApiClient().post(`ad`, vehicle);
    }
    getManufacturers(){
        return this.getApiClient().get(`manufacturer`);
    }
    getFuels(){
        return this.getApiClient().get(`fuel-type`);
    }
    getTransmissions(){
        return this.getApiClient().get(`transmission`);
    }
    getVehicleTypes(){
        return this.getApiClient().get(`vehicle-type`);
    }
    getModelFromManufacturerName(manufacturerName){
        return this.getApiClient().get(`model/${manufacturerName}`);
    }
}

export default VehicleService;