<script setup lang="ts">
</script>

<template>
  <div>
    <h2 class="text-2xl font-bold mb-6">编辑文章</h2>
    <n-form label-placement="left" label-width="80">
      <n-form-item label="标题">
        <n-input placeholder="请输入文章标题" />
      </n-form-item>
      <n-form-item label="内容">
        <n-input type="textarea" placeholder="Markdown 内容" :rows="20" />
      </n-form-item>
    </n-form>
  </div>
</template>
