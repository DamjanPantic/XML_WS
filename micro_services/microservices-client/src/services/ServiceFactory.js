import AuthService from './AuthService';
import RentalService from './RentalService';
import SearchService from './SearchService';

const rentalService = new RentalService();
const usersService = new AuthService();
const searchService = new SearchService();

const services = {
    users: usersService,
    search: searchService,
    rental: rentalService

};

export const ServiceFactory = {
    get: name => services[name]
};