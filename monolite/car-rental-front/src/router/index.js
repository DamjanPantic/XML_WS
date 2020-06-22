import Vue from 'vue';
import Router from 'vue-router';
import routes from './router-names';
import store from '../store'
import Register from '../views/Register.vue';
import Login from '../views/Login.vue';
import Home from '../views/Home.vue';
import AddVehicle from '../views/AddVehicle.vue';
import CommentsList from '../views/CommentsList.vue';
import GradesList from '../views/GradesList.vue';

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
      path: routes.REGISTER_ROUTE.path,
      name: routes.REGISTER_ROUTE.name,
      component: Register,
      meta: {
        requiresAuth: false
      }
    },
    {
      path: routes.HOME_ROUTE.path,
      name: routes.HOME_ROUTE.name,
      component: Home,
      // children: [],
      meta: {
        requiresAuth: false
      }
    },
    {
      path: routes.ADD_VEHICLE_ROUTE.path,
      name: routes.ADD_VEHICLE_ROUTE.name,
      component: AddVehicle,
      meta: {
        requiresAuth: true
      }
    },
    {
      path: routes.GRADES_ROUTE.path,
      name: routes.GRADES_ROUTE.name,
      component: GradesList,
      meta: {
        requiresAuth: true
      }
    },
    {
      path: routes.COMMENTS_ROUTE.path,
      name: routes.COMMENTS_ROUTE.name,
      component: CommentsList,
      meta: {
        requiresAuth: true
      }
    },
  ]
})

router.beforeEach((to, from, next) => {
  if (store.getters.user == null && to.meta.requiresAuth)
    next('/login');
  else
    next();
})

export default router;