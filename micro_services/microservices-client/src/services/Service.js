import axios from 'axios';

const baseDomain = process.env.VUE_APP_ENV === 'DEV' ? process.env.VUE_APP_BACKEND_URL_DEV : process.env.VUE_APP_BACKEND_URL_PROD;
const baseURL = `${baseDomain}`;

class Service {
    constructor(){
        this.client = axios.create({
            
            baseURL
        })
        this.setInterceptor();
    }
    setInterceptor = () => {
        this.client.interceptors.request.use(config => {        
        const token = window.localStorage.getItem("token");
    
        if (!!token) {
            Object.assign(config.headers, {
                Authorization: `Bearer ${token}`
            });
        }

        return config;
        });
      };
    
    attachHeaders(headers) {
        Object.assign(this.client.defaults.headers, headers);
    }

    detachHeader(headerKey) {
        delete this.client.defaults.headers[headerKey];
    }

    getApiClient() {
        return this.client;
    }
}

export default Service;