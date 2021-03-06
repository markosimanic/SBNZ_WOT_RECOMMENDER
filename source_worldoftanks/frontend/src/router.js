import Vue from 'vue'
import Router from 'vue-router'


import LoginPage from '@/components/homepage/LoginPage'
import RegisteredUserHomePage from '@/components/registered_user/RegisteredUserHomePage'
import PlaystylePage from '@/components/registered_user/PlaystylePage'
import AllTanksPage from '@/components/registered_user/AllTanksPage'
import UserStatsPage from '@/components/registered_user/UserStatsPage'
import BuyHistoryPage from '@/components/registered_user/BuyHistoryPage'


Vue.use(Router)

export default new Router({
    mode: 'history',
    
    routes: [
        {
            path: '/',
            component: LoginPage
        },
        {
            path: '/homepage',
            component: RegisteredUserHomePage
        },
        {
            path: '/playstyle',
            component: PlaystylePage
        },
        {
            path:'/all',
            component: AllTanksPage
        },
        {
            path:'/stats',
            component: UserStatsPage
        },
        {
            path:'/yourtanks',
            component:BuyHistoryPage
        }
    ]
})