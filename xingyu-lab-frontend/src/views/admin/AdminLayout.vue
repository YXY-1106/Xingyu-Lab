<script setup lang="ts">
import { h } from 'vue'
import { RouterView, RouterLink } from 'vue-router'
import type { MenuOption } from 'naive-ui'

const menuOptions: MenuOption[] = [
  { label: () => h(RouterLink, { to: '/admin/dashboard' }, { default: () => '仪表盘' }), key: 'dashboard' },
  { label: () => h(RouterLink, { to: '/admin/articles' }, { default: () => '文章管理' }), key: 'articles' },
  { label: () => h(RouterLink, { to: '/admin/categories' }, { default: () => '分类管理' }), key: 'categories' },
  { label: () => h(RouterLink, { to: '/admin/tags' }, { default: () => '标签管理' }), key: 'tags' },
  { label: () => h(RouterLink, { to: '/admin/projects' }, { default: () => '作品集' }), key: 'projects' },
  { label: () => h(RouterLink, { to: '/admin/photos' }, { default: () => '照片管理' }), key: 'photos' },
  { label: () => h(RouterLink, { to: '/admin/files' }, { default: () => '文件管理' }), key: 'files' },
  { label: () => h(RouterLink, { to: '/admin/settings' }, { default: () => '网站配置' }), key: 'settings' },
]
</script>

<template>
  <n-layout has-sider class="min-h-screen">
    <n-layout-sider bordered width="220">
      <div class="p-4 text-xl font-bold border-b">Xingyu Lab</div>
      <n-menu :options="menuOptions" />
    </n-layout-sider>

    <n-layout>
      <n-layout-header bordered class="h-14 flex items-center justify-between px-6">
        <span>后台管理</span>
        <n-button quaternary size="small">退出</n-button>
      </n-layout-header>
      <n-layout-content class="p-6">
        <RouterView />
      </n-layout-content>
    </n-layout>
  </n-layout>
</template>
