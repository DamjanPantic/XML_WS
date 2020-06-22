import Service from './Service';

const resource = '/reports';

class ReportService extends Service{
    addReport(vehicle) {
        return this.getApiClient().post(`${resource}`,vehicle);
    }
}

export default ReportService;