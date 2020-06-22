import Service from './Service';

const resource = '/comments';

class CommentService extends Service{
    getComments(id) {
        return this.getApiClient().get(`${resource}/${id}`);
    }
}

export default CommentService;