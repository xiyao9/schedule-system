import {createRouter,createWebHashHistory} from 'vue-router'
import login from '../components/Login.vue'
import regist from '../components/Regist.vue'
import showschedule from '../components/ShowSchedule.vue'
import pinia from '../pinia.js'
import {defineUser} from '../store/userStore.js'
let sysUser =defineUser(pinia)

const router = createRouter({
    history:createWebHashHistory(),
    routes:[
        {
            path:"/",
            redirect:'/showschedule'
            },
        {
            path:"/",
            component:showschedule
            },
        {
            path:"/login",
            component:login
            },
        {
            path:"/regist",
            component:regist
            },
        {
            path:"/showschedule",
            component:showschedule
        }
    ]
})
//路由的全局前置守卫 判断是否可以无登录访问ShowSchedule
router.beforeEach((to,from,next)=>{
    if(to.path=='/showschedule'){
        //登录过放行
        //没登录回到登录页
        if(sysUser.uid != 0){
            next()
        }else{
            next('/login')
        }
    }else{
        next()
    }
})
export default router
