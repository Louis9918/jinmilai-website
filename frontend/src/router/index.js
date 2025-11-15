import { createRouter, createWebHistory } from 'vue-router'

import HomeView from '../views/HomeView.vue'
import CompanyProfileView from '../views/CompanyProfileView.vue'
import ProductsView from '../views/ProductsView.vue'
import QualityServiceView from '../views/QualityServiceView.vue'
import CustomPackagingView from '../views/CustomPackagingView.vue'
import ContactView from '../views/ContactView.vue'

const router = createRouter({
  history: createWebHistory(import.meta.env.BASE_URL),
  routes: [
    // 默认重定向到中文首页
    {
      path: '/',
      redirect: '/zh'
    },
    {
      path: '/:lang(zh|en)',
      name: 'home',
      component: HomeView
    },
    {
      path: '/:lang(zh|en)/company',
      name: 'company',
      component: CompanyProfileView
    },
    {
      path: '/:lang(zh|en)/products',
      name: 'products',
      component: ProductsView
    },
    {
      path: '/:lang(zh|en)/quality',
      name: 'quality',
      component: QualityServiceView
    },
    {
      path: '/:lang(zh|en)/custom',
      name: 'custom',
      component: CustomPackagingView
    },
    {
      path: '/:lang(zh|en)/contact',
      name: 'contact',
      component: ContactView
    },
    // 兜底：任何未知路径都回到中文首页
    {
      path: '/:pathMatch(.*)*',
      redirect: '/zh'
    }
  ]
})

export default router
