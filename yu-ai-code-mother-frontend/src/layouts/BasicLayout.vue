<script setup lang="ts">
import { Layout } from 'ant-design-vue'
import GlobalHeader from '@/components/GlobalHeader/index.vue'
import GlobalFooter from '@/components/GlobalFooter/index.vue'
import { RouterView } from 'vue-router'

const { Header, Content } = Layout
</script>

<template>
  <a-layout class="basic-layout">
    <!-- 上方：导航栏 -->
    <a-layout-header class="layout-header">
      <GlobalHeader />
    </a-layout-header>

    <!-- 中间：内容区域，根据路由切换 -->
    <a-layout-content class="layout-content">
      <div class="content-inner">
        <RouterView />
      </div>
    </a-layout-content>

    <!-- 下方：版权信息（固定底部由 GlobalFooter 自身实现） -->
    <GlobalFooter />
  </a-layout>
</template>

<style scoped>
.basic-layout {
  min-height: 100vh;
  display: flex;
  flex-direction: column;
}

.layout-header {
  padding: 0;
  height: auto;
  line-height: 1;
  background: #fff;
  flex-shrink: 0;
}

.layout-content {
  flex: 1;
  padding: 24px;
  /* 为固定底部的 footer 预留空间，避免内容被遮挡 */
  padding-bottom: 72px;
  min-height: 0;
}

.content-inner {
  max-width: 1200px;
  margin: 0 auto;
  width: 100%;
}

/* 响应式：小屏减小内边距 */
@media (max-width: 768px) {
  .layout-content {
    padding: 16px;
    padding-bottom: 56px;
  }
}
</style>
