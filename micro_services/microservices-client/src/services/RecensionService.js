import Service from './Service';

const resource = '/recension';

class RecensionService extends Service{
    getPendingComments() {
        return this.getApiClient().get(`${resource}/comments/PENDING`);
    }

    approveComment(id) {
        return this.getApiClient().post(`${resource}/comment/approve/${id}`);
    }

    declineComment(id) {
        return this.getApiClient().post(`${resource}/comment/decline/${id}`);
    }
}


export default RecensionService;