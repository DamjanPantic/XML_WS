import AuthService from './AuthService';
import RentalService from './RentalService';
import SearchService from './SearchService';
import MessageService from './MessageService';

const rentalService = new RentalService();
const usersService = new AuthService();
const searchService = new SearchService();
const messageService = new MessageService();

const services = {
    users: usersService,
    search: searchService,
    rental: rentalService,
    message: messageService,
};

export const ServiceFactory = {
    get: name => services[name]
};