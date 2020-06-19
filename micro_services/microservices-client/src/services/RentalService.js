import Service from './Service';

const resource = '/rental';

class RentalService extends Service{

    fetchPendingRequests(owner) {
        return this.getApiClient().get(`${resource}/pending-requests/${owner}`);
    }


}


export default RentalService;