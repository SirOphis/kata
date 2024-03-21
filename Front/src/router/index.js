import {createRouter, createWebHistory} from 'vue-router'

import Product_detail from '../views/Product_detail.vue'
import Cart_page from '../views/Cart_page.vue'
import Home from '../views/Products_page.vue'


const routes = [
    {
        path:'/',
        name:'Home',
        component: Home
    },
    {
        path:'/Product_detail/:id', 
        name:'Product_detail',
        component: Product_detail
    },
    {
        path:'/Cart_page', 
        name:'Cart_page',
        component: Cart_page
    }
]

const router = createRouter({
    history: createWebHistory(),
    routes
})
export default router