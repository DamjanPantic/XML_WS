import AuthService from './AuthService';
import RentalService from './RentalService';

const usersService = new AuthService();
const rentalService = new RentalService();

const services = {
    users: usersService,
    rental: rentalService
};

export const ServiceFactory = {
    get: name => services[name]
};