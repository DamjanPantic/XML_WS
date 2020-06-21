export default {
    HOME_ROUTE: {path: '/', name: 'home_route'},
    REGISTER_ROUTE: {path: '/register', name: 'register_route'},
    PENDING_REQUESTS_ROUTE: {path: '/requests', name: 'requests_route'},
    VEHICLES_ROUTE: { path: '/', name: 'vehicles-route' },
    LOGIN_ROUTE: { path: '/login', name: 'login_route' },
    REGISTER_ROUTE: { path: '/register', name: 'register_route' },
    MESSAGES_ROUTE: {path: '/messages/:owner/:ownerId/:manufacturer/:model/:requestId', name: 'messages_route'},
    PENDING_COMMENTS: {path: '/comments', name: 'comments_route'}  ,
    USERS_REQUESTS_ROUTE: { path: '/user-requests/:id', name: 'users_requests-route'},
    CART_ROUTE: {path: '/cart', name: 'cart_route'},
    PAYMENT_CHECKOUT: {path: '/payment/:id', name: 'payment_route'},
    RESERVED_REQUEST_ROUTE: {path: '/reserved', name: 'reserved_request_route'}
}
