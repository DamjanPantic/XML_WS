import VehicleService from './VehicleService';
import AuthService from './AuthService';
import ReportService from './ReportService';

const vehicleService = new VehicleService();
const authService = new AuthService();
const reportService = new ReportService();

const services = {
    vehicle: vehicleService,
    auth: authService,
    report: reportService
};

export const ServiceFactory = {
    get: name => services[name]
};