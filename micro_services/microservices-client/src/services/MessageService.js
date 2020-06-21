import Service from './Service';

const resource = '/message';

class MessageService extends Service{
    sendMessage(message) {
        return this.getApiClient().post(`${resource}`, message);
    }
    getConversation(requestId) {
        return this.getApiClient().get(`${resource}/${requestId}`);
    }
}


export default MessageService;