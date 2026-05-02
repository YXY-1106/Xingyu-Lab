import { createRouter, createWebHistory } from 'vue-router'

const router = createRouter({
  history: createWebHistory(import.meta.env.BASE_URL),
  routes: [
    // 前台页面
    {
      path: '/',
      name: 'home',
      component: () => import('../views/front/HomeView.vue'),
    },
    {
      path: '/about',
      name: 'about',
      component: () => import('../views/front/AboutView.vue'),
    },
    {
      path: '/blog',
      name: 'blog',
      component: () => import('../views/front/BlogListView.vue'),
    },
    {
      path: '/blog/:id',
      name: 'blog-detail',
      component: () => import('../views/front/BlogDetailView.vue'),
    },
    {
      path: '/portfolio',
      name: 'portfolio',
      component: () => import('../views/front/PortfolioView.vue'),
    },
    {
      path: '/photos',
      name: 'photos',
      component: () => import('../views/front/PhotosView.vue'),
    },

    // 后台管理
    {
      path: '/admin/login',
      name: 'admin-login',
      component: () => import('../views/admin/LoginView.vue'),
    },
    {
      path: '/admin',
      component: () => import('../views/admin/AdminLayout.vue'),
      redirect: '/admin/dashboard',
      children: [
        {
          path: 'dashboard',
          name: 'admin-dashboard',
          component: () => import('../views/admin/DashboardView.vue'),
        },
        {
          path: 'articles',
          name: 'admin-articles',
          component: () => import('../views/admin/ArticleListView.vue'),
        },
        {
          path: 'articles/edit/:id?',
          name: 'admin-article-edit',
          component: () => import('../views/admin/ArticleEditView.vue'),
        },
        {
          path: 'categories',
          name: 'admin-categories',
          component: () => import('../views/admin/CategoryView.vue'),
        },
        {
          path: 'tags',
          name: 'admin-tags',
          component: () => import('../views/admin/TagView.vue'),
        },
        {
          path: 'projects',
          name: 'admin-projects',
          component: () => import('../views/admin/ProjectListView.vue'),
        },
        {
          path: 'photos',
          name: 'admin-photos',
          component: () => import('../views/admin/PhotoView.vue'),
        },
        {
          path: 'files',
          name: 'admin-files',
          component: () => import('../views/admin/FileView.vue'),
        },
        {
          path: 'settings',
          name: 'admin-settings',
          component: () => import('../views/admin/SettingsView.vue'),
        },
      ],
    },

    // 404
    {
      path: '/:pathMatch(.*)*',
      name: 'not-found',
      component: () => import('../views/NotFoundView.vue'),
    },
  ],
})

export default router
