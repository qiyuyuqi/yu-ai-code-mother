<script setup lang="ts">
// 版权信息：编程导航原创项目 by 程序员鱼皮
const footerLink = 'https://www.codefather.cn'
</script>

<template>
  <div class="global-footer">
    <span class="footer-text">
      编程导航原创项目 by
      <a :href="footerLink" target="_blank" rel="noopener noreferrer" class="footer-link">
        程序员鱼皮
      </a>
    </span>
  </div>
</template>

<style scoped>
.global-footer {
  position: fixed;
  bottom: 0;
  left: 0;
  right: 0;
  height: 48px;
  display: flex;
  align-items: center;
  justify-content: center;
  background: #fafafa;
  border-top: 1px solid #f0f0f0;
  z-index: 100;
}

.footer-text {
  font-size: 14px;
  color: rgba(0, 0, 0, 0.65);
}

.footer-link {
  color: #1677ff;
  text-decoration: none;
  margin-left: 4px;
}

.footer-link:hover {
  text-decoration: underline;
}

@media (max-width: 768px) {
  .global-footer {
    height: 40px;
    font-size: 12px;
  }
}
</style>
