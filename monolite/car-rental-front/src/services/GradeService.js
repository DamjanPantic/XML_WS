import Service from './Service';

const resource = '/grade';

class GradeService extends Service{
    getGrades(id) {
        return this.getApiClient().get(`${resource}/${id}`);
    }
}

export default GradeService;