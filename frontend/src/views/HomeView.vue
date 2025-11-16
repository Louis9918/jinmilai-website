<!-- frontend/src/views/HomeView.vue -->
<template>
  <div class="page page-home">
    <div class="container">
      <!-- 顶部 Hero：左文案 + 右轮播 -->
      <section class="hero-banner">
        <div class="hero-grid">
          <!-- 左侧文案 -->
          <div class="hero-copy">
            <div class="hero-pill">
              {{
                currentLang === 'zh'
                  ? '氨基酸 · 蛋白粉 · 复合粉体'
                  : 'Amino Acids · Protein Powders · Compound Blends'
              }}
            </div>

            <h1 class="hero-title">
              {{
                currentLang === 'zh'
                  ? '以质立企，以服致远'
                  : 'Built on Quality, Guided by Service'
              }}
            </h1>

            <p class="hero-subtitle">
              {{
                currentLang === 'zh'
                  ? '中国出口商检最快的氨基酸生产厂家，服务全球农业、饲料、食品与科研伙伴。'
                  : 'The amino acid manufacturer with the fastest China export inspection clearance, serving global agriculture, feed, food and research partners.'
              }}
            </p>

            <div class="hero-actions">
              <RouterLink
                class="btn btn-primary"
                :to="{ name: 'products', params: { lang: currentLang } }"
              >
                {{ currentLang === 'zh' ? '了解产品' : 'View Products' }}
              </RouterLink>
              <RouterLink
                class="btn btn-outline"
                :to="{ name: 'company', params: { lang: currentLang } }"
              >
                {{ currentLang === 'zh' ? '走进金米莱' : 'About Jinmilai' }}
              </RouterLink>
            </div>
          </div>

          <!-- 右侧图片轮播 -->
          <div class="hero-slider">
            <div
              v-for="(slide, index) in slides"
              :key="index"
              class="hero-slide"
              :class="{ 'hero-slide--active': index === activeIndex }"
              :style="{
                backgroundImage: `linear-gradient(135deg, rgba(0,0,0,0.38), rgba(0,0,0,0.15)), url(${slide.image})`
              }"
            >
              <div class="hero-slide-content">
                <div class="hero-slide-tag">
                  {{ slide.tag }}
                </div>
                <h3 class="hero-slide-title">
                  {{ slide.title }}
                </h3>
                <p class="hero-slide-desc">
                  {{ slide.desc }}
                </p>
              </div>
            </div>

            <div class="hero-dots">
              <button
                v-for="(slide, index) in slides"
                :key="index"
                class="hero-dot"
                :class="{ 'hero-dot--active': index === activeIndex }"
                type="button"
                @click="goToSlide(index)"
              />
            </div>
          </div>
        </div>
      </section>

      <!-- 公司概况卡片 -->
      <section class="home-intro section-card section-card--soft">
        <h2 class="home-intro-title">
          {{ currentLang === 'zh' ? '公司概况' : 'Company Profile' }}
        </h2>
        <p class="home-intro-text">
          {{ companyIntro }}
        </p>
      </section>

      <!-- 产品与应用卡片 -->
      <section class="home-intro section-card">
        <h2 class="home-intro-title">
          {{ currentLang === 'zh' ? '产品与应用' : 'Products & Applications' }}
        </h2>
        <p class="home-intro-text">
          {{ productsIntro }}
        </p>
      </section>

      <!-- 关键数字卡片区 -->
      <section class="home-stats-card section-card section-card--accent-border">
        <div class="home-stats">
          <div class="stat-card" v-for="item in stats" :key="item.key">
            <div class="stat-value">{{ item.value }}</div>
            <div class="stat-label">{{ item.label }}</div>
          </div>
        </div>
      </section>
    </div>
  </div>
</template>

<script setup>
import {
  ref,
  computed,
  onMounted,
  onBeforeUnmount,
  watch
} from 'vue'
import { useRoute } from 'vue-router'

import heroPlant from '@/assets/hero-plant.jpg'
import heroLab from '@/assets/hero-lab.jpg'
import heroLogistics from '@/assets/hero-plant.jpg'

const route = useRoute()

const currentLang = computed(() => {
  const lang = route.params.lang
  return lang === 'en' ? 'en' : 'zh'
})

// 公司简介简版
const companyIntro = computed(() =>
  currentLang.value === 'zh'
    ? '江苏金米莱生物科技有限公司成立于 2021 年，注册资本 1100 万元，现有厂区约 6 万平方米，专注于氨基酸、蛋白粉及其复合粉体的研发与制造，配套自有研发实验室与质量检测中心，建立从原料到成品的全流程质量管控与可追溯体系，目前 80% 以上产品出口至全球多个市场。'
    : 'Jiangsu Jinmilai Biotech Co., Ltd. was established in 2021 with a registered capital of RMB 11 million and a manufacturing campus of approximately 60,000 m². We focus on the R&D and production of amino acids, protein powders, and compound powder blends, supported by in-house R&D laboratories and a dedicated quality testing center, with over 80% of our output exported worldwide.'
)

// 产品与应用简版
const productsIntro = computed(() =>
  currentLang.value === 'zh'
    ? '公司以羽毛蛋白等为来源生产氨基酸，核心产品包括胱氨酸、亮氨酸、酪氨酸，以及复合氨基酸粉系列，广泛应用于医药、食品、化妆品以及生化与营养学研究等领域，并为客户提供规格定制、配方建议与技术支持，协助从打样验证迈向规模化生产。'
    : 'Leveraging feather-derived proteins, Jinmilai produces L-Cystine, L-Leucine, L-Tyrosine, and a portfolio of compound amino acid powders. Applications span pharmaceuticals, food & beverage, cosmetics, and biochemical/nutrition research, with customized specifications, formulation advice, and technical support to bridge pilot trials and full-scale manufacturing.'
)

// 数字卡片
const stats = computed(() => {
  if (currentLang.value === 'en') {
    return [
      { key: 'year', value: '2021', label: 'Year of Establishment' },
      { key: 'capital', value: 'RMB 11M', label: 'Registered Capital' },
      { key: 'area', value: '60,000 m²', label: 'Manufacturing Campus' },
      { key: 'export', value: '80%+', label: 'Export Share' }
    ]
  }
  return [
    { key: 'year', value: '2021', label: '成立年份' },
    { key: 'capital', value: '1,100 万元', label: '注册资本' },
    { key: 'area', value: '约 60,000 m²', label: '厂区面积' },
    { key: 'export', value: '80%+', label: '出口占比' }
  ]
})

// 轮播数据
const slides = computed(() => {
  if (currentLang.value === 'zh') {
    return [
      {
        image: heroPlant,
        tag: '农业与植物营养',
        title: '复合氨基酸原粉 · 全水溶 · 全营养',
        desc: '适用于滴灌、冲施、水溶肥等多种植物营养配方，助力作物稳产增产。'
      },
      {
        image: heroLab,
        tag: '研发与质控',
        title: '自有实验室与质量检测中心',
        desc: '从原料准入到成品放行的全流程质量管控与可追溯体系。'
      },
      {
        image: heroLogistics,
        tag: '全球交付',
        title: '80%+ 产品出口全球',
        desc: '成熟的报检与合规流程，支撑高效稳定的国际交付体验。'
      }
    ]
  }
  return [
    {
      image: heroPlant,
      tag: 'Agriculture & Plant Nutrition',
      title: 'Compound Amino Acid Powders · Fully Water-soluble',
      desc: 'Ideal for drip irrigation, fertigation and water-soluble fertilizers to support stable and higher yields.'
    },
    {
      image: heroLab,
      tag: 'R&D and Quality Control',
      title: 'In-house Labs & Testing Center',
      desc: 'End-to-end quality management and traceability from raw materials to finished products.'
    },
    {
      image: heroLogistics,
      tag: 'Global Delivery',
      title: '80%+ Exported Worldwide',
      desc: 'Streamlined export-compliance workflow enabling reliable lead times and a smooth customer experience.'
    }
  ]
})

const activeIndex = ref(0)
let slideTimer = null

function nextSlide() {
  const total = slides.value.length
  if (!total) return
  activeIndex.value = (activeIndex.value + 1) % total
}

function goToSlide(index) {
  activeIndex.value = index
}

onMounted(() => {
  slideTimer = setInterval(nextSlide, 7000)
})

onBeforeUnmount(() => {
  if (slideTimer) {
    clearInterval(slideTimer)
    slideTimer = null
  }
})

// 切换中英文时重置到第一张
watch(currentLang, () => {
  activeIndex.value = 0
})
</script>

<style scoped>
.home-intro {
  margin-top: 20px;
}

.home-intro-title {
  font-size: 20px;
  margin: 0 0 8px;
  color: #333333;
}

.home-intro-text {
  font-size: 14px;
  color: #555555;
  line-height: 1.7;
}
</style>
