import Service from './Service';

const resource = '/auth';

class AuthService extends Service{
    register(user) {
        return this.getApiClient().post(`${resource}/register`, user);
    }
    login(user){
        return this.getApiClient().post(`${resource}/login`, user);
    }
}

export default AuthService;