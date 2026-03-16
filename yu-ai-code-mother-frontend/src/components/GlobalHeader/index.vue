<script setup lang="ts">
import { ref, computed } from 'vue'
import { useRoute, useRouter } from 'vue-router'
import { Menu } from 'ant-design-vue'
import type { MenuProps } from 'ant-design-vue'

// 菜单项配置类型
export interface MenuItemConfig {
  key: string
  path: string
  label: string
}

// 通过配置设置菜单项（可根据需要扩展）
const menuItems: MenuItemConfig[] = [
  { key: 'home', path: '/', label: '首页' },
  { key: 'about', path: '/about', label: '关于' },
]

const route = useRoute()
const router = useRouter()

// 当前选中的菜单 key，根据当前路由高亮
const selectedKeys = computed(() => {
  const path = route.path
  const item = menuItems.find((m) => m.path === path)
  return item ? [item.key] : []
})

// 转换为 Ant Design Menu 需要的格式
const menuOptions: MenuProps['items'] = menuItems.map((item) => ({
  key: item.key,
  label: item.label,
}))

// 菜单点击时跳转
const handleMenuClick: MenuProps['onClick'] = ({ key }) => {
  const item = menuItems.find((m) => m.key === key)
  if (item) {
    router.push(item.path)
  }
}

// 网站标题
const siteTitle = ref('AI 编程导航')
</script>

<template>
  <div class="global-header">
    <!-- 左侧：Logo 与网站标题 -->
    <div class="header-left">
      <router-link to="/" class="logo-link">
        <!-- 左侧展示 logo：将 logo.png 放入 src/assets 后可改为 src="@/assets/logo.png" -->
        <img
          src="@/assets/logo.svg"
          alt="Logo"
          class="logo-img"
        />
        <span class="site-title">{{ siteTitle }}</span>
      </router-link>
    </div>

    <!-- 中间：导航菜单 -->
    <div class="header-menu">
      <Menu
        v-model:selectedKeys="selectedKeys"
        mode="horizontal"
        :items="menuOptions"
        @click="handleMenuClick"
      />
    </div>

    <!-- 右侧：登录按钮（暂替代头像和昵称） -->
    <div class="header-right">
      <a-button type="primary">登录</a-button>
    </div>
  </div>
</template>

<style scoped>
.global-header {
  display: flex;
  align-items: center;
  justify-content: space-between;
  padding: 0 24px;
  height: 64px;
  background: #fff;
  box-shadow: 0 1px 4px rgba(0, 0, 0, 0.08);
}

.header-left {
  display: flex;
  align-items: center;
  flex-shrink: 0;
}

.logo-link {
  display: flex;
  align-items: center;
  gap: 12px;
  text-decoration: none;
  color: rgba(0, 0, 0, 0.88);
}

.logo-img {
  height: 32px;
  width: auto;
  display: block;
}

.site-title {
  font-size: 18px;
  font-weight: 600;
  white-space: nowrap;
}

.header-menu {
  flex: 1;
  display: flex;
  justify-content: center;
  min-width: 0;
}

.header-menu :deep(.ant-menu) {
  border-bottom: none;
  line-height: 62px;
}

.header-right {
  flex-shrink: 0;
}

/* 响应式：小屏时缩小间距与字体 */
@media (max-width: 768px) {
  .global-header {
    padding: 0 16px;
    height: 56px;
  }

  .logo-img {
    height: 28px;
  }

  .site-title {
    font-size: 16px;
  }

  .header-menu :deep(.ant-menu-item) {
    padding: 0 12px;
    font-size: 14px;
  }
}
</style>
