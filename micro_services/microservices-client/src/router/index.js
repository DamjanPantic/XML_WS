import Vue from 'vue';
import Router from 'vue-router';
import Home from '../views/Home.vue';
import Login from '../views/Login.vue';
import Register from '../views/Register.vue';
import routes from './router-names'; 
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
      }
    ]
  })

  router.beforeEach((to, from, next) => {
    if(!localStorage.getItem('token') && to.meta.requiresAuth)
      next('/login');
    else
      next();
    
  })

  export default router;