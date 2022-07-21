import Vue from 'vue'
import VueRouter from 'vue-router'

import layout from '../layout/layout.vue';



Vue.use(VueRouter)

const routes = [
  {
    path: '/',
    name: 'layout',
    component: layout,
    redirect:"/login",
    children:[
      {
        path: 'home',
        name: 'Home',
        component: ()=>import("@/views/HomeView"),
        meta: { permission: true },
      },
      {
        path: 'stu-inf',
        name: 'stu-inf',
        component: ()=>import("@/views/studentimf"),
        meta: { permission: true },
      },
      {
        path: 'change-inf',
        name: 'change-inf',
        component: ()=>import("@/views/changeimf"),
        meta: { permission: true },
      },
      {
        path: 'mygrade',
        name: 'mygrade',
        component: ()=>import("@/views/mygrade"),
        meta: { permission: true },
      },
      {
        path: 'exam',
        name: 'exam',
        component: ()=>import("@/views/exam"),
        meta: { permission: true },
      },
      {
        path: 'examstart',
        name: 'examstart',
        component: ()=>import("@/views/examstart"),
        beforeEnter:(to, from, next)=> {
          console.log("路由守卫")
          if (sessionStorage.getItem("token")) {
            next();
          } else {
            alert("请先登录");
            next("/login");
          }
        },
        meta: { permission: true,choosecheck:true },
      },
      {
        path: 'practice',
        name: 'practice',
        component: ()=>import("@/views/practice"),
        meta: { permission: true },
      },
      {
        path: 'mistake',
        name: 'mistake',
        component: ()=>import("@/views/mistake"),
        meta: { permission: true },
      },
      {
        path: 'choose',
        name: 'choose',
        component: ()=>import("@/views/choose"),
        meta: { permission: true },
      },
      {
        path:'reviewPaper',
        name:'reviewPaper',
        component: ()=>import("@/views/reviewPaper"),
        meta: { permission: true },
      }
    ]
  },

  {
    path: '/person',
    name: 'person',
    component: ()=>import("@/views/person"),
    meta: { permission: true },
  },
  {
    path:'/login',
    name:'Login',
    component: ()=>import("@/views/login(1)"),
  }
  ,
  {
    path:'/Register',
    name:'Register',
    component: ()=>import("@/views/Register")
  }
]


const router = new VueRouter({
  mode: 'history',
  base: process.env.BASE_URL,
  routes
})


router.beforeEach((to, from, next) => {
  if (to.meta.permission) {
    if (sessionStorage.getItem("token")) {
      if (to.meta.choosecheck)
        {console.log('check')
        if (localStorage.getItem("selected") === 'true') next();
        else {
          next("/choose")
        }
    }
      else next();

  } else {
    alert("请先登录");
    next("/login");
  }
}else {
    next();
  }
});
export default router
