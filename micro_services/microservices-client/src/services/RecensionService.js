import Service from './Service';

const resource = '/recension';

class RecensionService extends Service{
    getPendingComments() {
        return this.getApiClient().get(`${resource}/comments/PENDING`);
    }
}


export default RecensionService;