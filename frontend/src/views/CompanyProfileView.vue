<!-- frontend/src/views/CompanyProfileView.vue -->
<template>
  <div class="page page-company">
    <div class="container company-container">
      <h2 class="page-title">
        {{ currentLang === 'zh' ? '公司概况' : 'Company Profile' }}
      </h2>

      <section class="company-section section-card section-card--soft">
        <p class="company-text">
          {{ profileText }}
        </p>
      </section>

      <section class="company-section section-card">
        <h3 class="section-subtitle">
          {{ currentLang === 'zh' ? '核心优势' : 'Key Highlights' }}
        </h3>
        <ul class="highlights-list">
          <li>
            {{
              currentLang === 'zh'
                ? '自有研发实验室与质量检测中心，覆盖从原料到成品的全流程质量管控与可追溯体系。'
                : 'In-house R&D laboratories and a dedicated quality testing center supporting end-to-end quality management and traceability from raw materials to finished goods.'
            }}
          </li>
          <li>
            {{
              currentLang === 'zh'
                ? '专注氨基酸、蛋白粉及复合粉体，服务医药、食品、化妆品、生化与营养学研究等多元领域。'
                : 'Specialized in amino acids, protein powders, and compound powder blends serving pharmaceuticals, food & beverage, cosmetics, and biochemical/nutrition research.'
            }}
          </li>
          <li>
            {{
              currentLang === 'zh'
                ? '80% 以上产品出口至东南亚、非洲、中东、欧洲、北美、中美、南美等海外市场。'
                : 'Over 80% of output exported to Southeast Asia, Africa, the Middle East, Europe, and North, Central, and South America.'
            }}
          </li>
        </ul>
      </section>
    </div>
  </div>
</template>


<script setup>
import { computed } from 'vue'
import { useRoute } from 'vue-router'

const route = useRoute()
const currentLang = computed(() =>
  route.params.lang === 'en' ? 'en' : 'zh'
)

const profileText = computed(() =>
  currentLang.value === 'zh'
    ? '江苏金米莱生物科技有限公司成立于 2021 年，注册资本 1100 万元，现有厂区约 6 万平方米。公司专注于氨基酸、蛋白粉及其复合粉体的研发与制造，配套自有研发实验室与质量检测中心，建立从原料到成品的全流程质量管控与可追溯体系，为全球客户持续提供稳定可靠的产品与服务。目前 80% 以上产品出口至东南亚、非洲、中东、欧洲、北美、中美、南美等市场。'
    : 'Jiangsu Jinmilai Biotech Co., Ltd. was established in 2021 with a registered capital of RMB 11 million and a manufacturing campus of approximately 60,000 m². We specialize in the R&D and production of amino acids, protein powders, and compound powder blends. Backed by in-house R&D laboratories and a dedicated quality testing center, we operate an end-to-end quality management and traceability system from raw materials to finished goods, ensuring consistently reliable products and services for customers worldwide. At present, over 80% of our output is exported to markets in Southeast Asia, Africa, the Middle East, Europe, and North, Central, and South America.'
)
</script>

<style scoped>
.company-container {
  max-width: 900px;
}

.company-section {
  margin-top: 16px;
}

.company-text {
  font-size: 15px;
  color: #555555;
  line-height: 1.8;
}

.section-subtitle {
  font-size: 18px;
  margin: 8px 0 6px;
  color: #333333;
}

.highlights-list {
  padding-left: 18px;
  margin: 0;
  font-size: 14px;
  color: #555555;
  line-height: 1.8;
}

.highlights-list li {
  margin-bottom: 6px;
}
</style>
