import AuthService from './AuthService';
import SearchService from './SearchService';

const usersService = new AuthService();
const searchService = new SearchService();

const services = {
    users: usersService,
    search: searchService,
};

export const ServiceFactory = {
    get: name => services[name]
};