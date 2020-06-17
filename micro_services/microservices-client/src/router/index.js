import Vue from 'vue';
import Router from 'vue-router';
import Home from '../components/Home';
import Login from '../components/Login';
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