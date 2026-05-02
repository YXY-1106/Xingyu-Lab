<script setup lang="ts">
</script>

<template>
  <div>
    <div class="flex justify-between items-center mb-6">
      <h2 class="text-2xl font-bold">作品集管理</h2>
      <n-button type="primary">新增项目</n-button>
    </div>
    <n-data-table :columns="[]" :data="[]" />
  </div>
</template>
