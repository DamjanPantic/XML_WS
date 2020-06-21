import AuthService from './AuthService';
import RentalService from './RentalService';
import SearchService from './SearchService';
import MessageService from './MessageService';
import RecensionService from './RecensionService';

const rentalService = new RentalService();
const usersService = new AuthService();
const searchService = new SearchService();
const messageService = new MessageService();
const recensionService = new RecensionService();

const services = {
    users: usersService,
    search: searchService,
    rental: rentalService,
    message: messageService,
    recension: recensionService
};

export const ServiceFactory = {
    get: name => services[name]
};