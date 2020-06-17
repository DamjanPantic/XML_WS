import AuthService from './AuthService';


const usersService = new AuthService();

const services = {
    users: usersService
};

export const ServiceFactory = {
    get: name => services[name]
};