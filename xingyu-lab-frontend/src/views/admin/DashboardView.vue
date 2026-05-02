<script setup lang="ts">
</script>

<template>
  <div>
    <h2 class="text-2xl font-bold mb-6">仪表盘</h2>
    <n-grid :cols="4" :x-gap="16" :y-gap="16">
      <n-gi>
        <n-card title="文章数">0</n-card>
      </n-gi>
      <n-gi>
        <n-card title="浏览量">0</n-card>
      </n-gi>
      <n-gi>
        <n-card title="照片数">0</n-card>
      </n-gi>
      <n-gi>
        <n-card title="文件数">0</n-card>
      </n-gi>
    </n-grid>
  </div>
</template>
