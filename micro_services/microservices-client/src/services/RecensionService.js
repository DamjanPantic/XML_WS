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

    addGrade(grade) {
        return this.getApiClient().post(`${resource}/add-grade`, grade);
    }

    getRating(id) {
        return this.getApiClient().get(`${resource}/rating/${id}`);
    }

    getGradeByUser(vehicleId,userId) {
        return this.getApiClient().get(`${resource}/grade/${vehicleId}/${userId}`);
    }
}


export default RecensionService;