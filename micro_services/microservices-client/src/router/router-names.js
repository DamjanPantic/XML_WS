export default {
    HOME_ROUTE: {path: '/', name: 'home_route'},
    REGISTER_ROUTE: {path: '/register', name: 'register_route'},
    PENDING_REQUESTS_ROUTE: {path: '/requests', name: 'requests_route'},
    VEHICLES_ROUTE: { path: '/', name: 'vehicles-route' },
    LOGIN_ROUTE: { path: '/login', name: 'login_route' },
    REGISTER_ROUTE: { path: '/register', name: 'register_route' },
    USERS_REQUESTS_ROUTE: { path: '/requests/:id', name: 'users_requests_route'},
    MESSAGES_ROUTE: {path: '/messages/:owner/:ownerId/:manufacturer/:model/:requestId', name: 'messages_route'},
    PENDING_COMMENTS: {path: '/comments', name: 'comments_route'}  

}
