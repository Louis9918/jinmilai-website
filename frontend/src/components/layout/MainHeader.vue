<!-- frontend/src/components/layout/MainHeader.vue -->
<template>
  <header class="site-header">
    <div class="container header-inner">
      <!-- LOGO：图 + 字 -->
      <div class="logo" @click="goHome">
        <img
          class="logo-img"
          :src="logoImg"
          alt="Jiangsu Jinmilai Biotech Co., Ltd."
        />
        <div class="logo-text">
          <div class="logo-text-cn">江苏金米莱生物科技有限公司</div>
          <div class="logo-text-en">JIANGSU JINMILAI BIOTECH CO., LTD.</div>
        </div>
      </div>

      <!-- 桌面端导航 / 移动端下拉导航 -->
      <nav
        class="header-nav"
        :class="{
          'header-nav--open': isMobileMenuOpen
        }"
      >
        <RouterLink
          v-for="item in currentNavItems"
          :key="item.name"
          class="nav-link"
          :to="{
            name: item.name,
            params: { lang: currentLang },
            query: route.query
          }"
        >
          {{ item.label }}
        </RouterLink>
      </nav>

      <!-- 右侧：语言切换 + 手机菜单按钮 -->
      <div class="header-right">
        <div class="lang-switch">
          <button
            class="lang-btn"
            :class="{ 'lang-btn--active': currentLang === 'zh' }"
            type="button"
            @click="switchLang('zh')"
          >
            中
          </button>
          <span class="lang-divider">|</span>
          <button
            class="lang-btn"
            :class="{ 'lang-btn--active': currentLang === 'en' }"
            type="button"
            @click="switchLang('en')"
          >
            EN
          </button>
        </div>

        <button
          class="menu-btn"
          type="button"
          aria-label="Toggle navigation"
          @click="toggleMobileMenu"
        >
          ☰
        </button>
      </div>
    </div>
  </header>
</template>

<script setup>
import { ref, computed, watch } from 'vue'
import { useRoute, useRouter } from 'vue-router'
import logoImg from '@/assets/logo-jml.png' // 这里引用刚才放进去的图片

const route = useRoute()
const router = useRouter()

const isMobileMenuOpen = ref(false)

// 当前语言：从路由参数中取，默认 zh
const currentLang = computed(() => {
  const lang = route.params.lang
  return lang === 'en' ? 'en' : 'zh'
})

// 导航项：路由名 + 中英文 label
const baseNavItems = [
  { name: 'home', labelZh: '首页', labelEn: 'Home' },
  { name: 'company', labelZh: '公司概况', labelEn: 'Company' },
  { name: 'products', labelZh: '产品与应用', labelEn: 'Products' },
  { name: 'quality', labelZh: '质量与服务', labelEn: 'Quality & Service' },
  { name: 'custom', labelZh: '定制与包装', labelEn: 'Custom & Packaging' },
  { name: 'contact', labelZh: '联系我们', labelEn: 'Contact' }
]

const currentNavItems = computed(() => {
  const lang = currentLang.value
  return baseNavItems.map((item) => ({
    ...item,
    label: lang === 'en' ? item.labelEn : item.labelZh
  }))
})

function goHome() {
  router.push({
    name: 'home',
    params: { lang: currentLang.value },
    query: route.query
  })
}

function switchLang(lang) {
  if (lang === currentLang.value) return

  const targetName = route.name || 'home'

  router.push({
    name: targetName,
    params: {
      ...route.params,
      lang
    },
    query: route.query
  })
}

function toggleMobileMenu() {
  isMobileMenuOpen.value = !isMobileMenuOpen.value
}

// 路由变化时自动收起手机端菜单
watch(
  () => route.fullPath,
  () => {
    isMobileMenuOpen.value = false
  }
)
</script>
