import Service from './Service';

const resource = '/auth';

class AuthService extends Service{
    login(user) {
        return this.getApiClient().post(`${resource}/login`, user);
    }
    register(user) {
        return this.getApiClient().post(`${resource}/register`, user);
    }

}


export default AuthService;