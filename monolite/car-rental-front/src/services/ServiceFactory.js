import VehicleService from './VehicleService';
import AuthService from './AuthService';

const vehicleService = new VehicleService();
const authService = new AuthService();

const services = {
    vehicle: vehicleService,
    auth: authService,
};

export const ServiceFactory = {
    get: name => services[name]
};