import Service from './Service';

const resource = '';

class AuthService extends Service{
    login(user) {
        return this.getApiClient().post(`${resource}/login`, user);
    }

    register(user) {
        return this.getApiClient().post(`${resource}/sign-up`, user);
    }

}


export default AuthService;