import Vue from 'vue';
import Router from 'vue-router';
import Home from '../views/Home.vue';
import Login from '../views/Login.vue';
import Register from '../views/Register.vue';
import PendingRequests from '../components/rental/PendingRequests';
import routes from './router-names';
import Vehicles from '../views/Vehicles.vue';
import UsersRequests from '../views/UsersRequests.vue';
import Cart from '../components/cart/Cart';
import Payment from '../components/cart/Payment';
import Messages from '../views/Messages.vue';
import PendingCommentsList from '../views/PendingCommentsList.vue'
import VehicleInfo from '../views/VehicleInfo.vue'

import ReservedRequests from '../components/rental/ReserverdRequests';

Vue.use(Router);

const router = new Router({
  mode: 'history',
  routes: [
    {
      path: routes.LOGIN_ROUTE.path,
      name: routes.LOGIN_ROUTE.name,
      component: Login,
      meta: {
        requiresAuth: false
      }
    },
    {
      path: routes.HOME_ROUTE.path,
      name: routes.HOME_ROUTE.name,
      component: Home,
      children: [
        {
          path: routes.VEHICLES_ROUTE.path,
          name: routes.VEHICLES_ROUTE.name,
          component: Vehicles,
          meta: {
            requiresAuth: false
          }
        },
        {
          path: routes.VEHICLE_INFO_ROUTE.path,
          name: routes.VEHICLE_INFO_ROUTE.name,
          component: VehicleInfo,
          meta: {
            requiresAuth: false
          }
        },
        {
          path: routes.USERS_REQUESTS_ROUTE.path,
          name: routes.USERS_REQUESTS_ROUTE.name,
          component: UsersRequests,
          meta: {
            requiresAuth: true
          }
        },
        {
          path: routes.CART_ROUTE.path,
          name: routes.CART_ROUTE.name,
          component: Cart,
          meta: {
            requiresAuth: false
          }
        },
        {
          path: routes.PAYMENT_CHECKOUT.path,
          name: routes.PAYMENT_CHECKOUT.name,
          component: Payment,
          meta: {
            requiresAuth: false
          }
        },
        {
          path: routes.MESSAGES_ROUTE.path,
          name: routes.MESSAGES_ROUTE.name,
          component: Messages,
          meta: {
            requiresAuth: true
          }
        },
        {
          path: routes.PENDING_COMMENTS.path,
          name: routes.PENDING_COMMENTS.name,
          component: PendingCommentsList,
          meta: {
            requiresAuth: true
          }
        },

        {
          path: routes.PENDING_REQUESTS_ROUTE.path,
          name: routes.PENDING_REQUESTS_ROUTE.name,
          component: PendingRequests,
          meta: {
            requiresAuth: false
          }
        },
        {
          path: routes.RESERVED_REQUEST_ROUTE.path,
          name: routes.RESERVED_REQUEST_ROUTE.name,
          component: ReservedRequests,
          meta: {
            requiresAuth: false
          }
        },
      ]
    },
    {
      path: routes.REGISTER_ROUTE.path,
      name: routes.REGISTER_ROUTE.name,
      component: Register,
      meta: {
        requiresAuth: false
      }
    }
  ]
})

router.beforeEach((to, from, next) => {
  if (!localStorage.getItem('token') && to.meta.requiresAuth)
    next('/login');
  else
    next();

})

export default router;