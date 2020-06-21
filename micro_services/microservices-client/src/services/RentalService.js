import Service from './Service';

const resource = '/rental';

class RentalService extends Service{

    fetchPendingRequests(owner) {
        return this.getApiClient().get(`${resource}/pending-requests/${owner}`);
    }

    acceptDeclineRequest(approbalObj){
        return this.getApiClient().post(`${resource}/approval`, approbalObj);
    }

    sendRequest(rentalRequestObj){
        return this.getApiClient().post(`${resource}`,rentalRequestObj);
    }

    getUserRentalRequest(user){
        if (user.username === "Test") {
            return this.getApiClient().get(`${resource}/owner/${user.id}`);
        }else{
            return this.getApiClient().get(`${resource}/customer/${user.id}`);
        }
    }

    fetchReservedRequests(customer) {
        return this.getApiClient().get(`${resource}/reserved-requests/${customer}`);
    }

    payRequest(requestId) {
        return this.getApiClient().post(`${resource}/${requestId}/pay`);
    }
}


export default RentalService;