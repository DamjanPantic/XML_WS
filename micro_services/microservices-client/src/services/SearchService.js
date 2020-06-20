import Service from './Service';

const resource = '/search';

class SearchService extends Service{
    getVehiclesByPage(pageNo) {
        return this.getApiClient().get(`${resource}/get?pageNo=${pageNo-1}`);
    }
}

export default SearchService;