<script setup lang="ts">
</script>

<template>
  <div>
    <h2 class="text-2xl font-bold mb-6">网站配置</h2>
    <n-form label-placement="left" label-width="100">
      <n-form-item label="站点名称">
        <n-input placeholder="Xingyu Lab" />
      </n-form-item>
      <n-form-item label="Slogan">
        <n-input placeholder="Java 是我的起点，AI 是我的下一站" />
      </n-form-item>
      <n-form-item>
        <n-button type="primary">保存</n-button>
      </n-form-item>
    </n-form>
  </div>
</template>
