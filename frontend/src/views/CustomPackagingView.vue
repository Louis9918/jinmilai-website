<!-- frontend/src/views/CustomPackagingView.vue -->
<template>
  <div class="page page-custom">
    <div class="container custom-container">
      <h2 class="page-title">
        {{ currentLang === 'zh' ? '定制与包装' : 'Custom Specifications & Packaging' }}
      </h2>

      <section class="custom-section section-card section-card--soft">
        <h3 class="section-subtitle">
          {{ currentLang === 'zh' ? '配方定制' : 'Formulation Customization' }}
        </h3>
        <p class="custom-text">
          {{ formulaText }}
        </p>
      </section>

      <section class="custom-section section-card">
        <h3 class="section-subtitle">
          {{ currentLang === 'zh' ? '包装规格' : 'Packaging Options' }}
        </h3>
        <p class="custom-text">
          {{ packagingText }}
        </p>
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

const formulaText = computed(() =>
  currentLang.value === 'zh'
    ? '我们的所有产品均支持按需定制配方：可根据目标应用调节氨基酸或蛋白含量，并可按需添加或与 Fe、Zn、Mn、Cu、B、Mo、Mg、K 等微/常量元素络合，以满足饲料、培养基、肥料等体系的性能要求。'
    : 'Formulation customization is available across all product lines: amino acid or protein content can be adjusted to any target specification, with optional addition or chelation of trace/macro elements (Fe, Zn, Mn, Cu, B, Mo, Mg, K) to meet the performance requirements of feed, culture-media, fertilizer and other systems.'
)

const packagingText = computed(() =>
  currentLang.value === 'zh'
    ? '包装方面，提供 1/2/3/5/10/20/25 kg/袋等标准规格，内袋为 PE，外袋为牛皮纸袋或编织袋；包装材质、规格与标识均可按需定制。'
    : 'For packaging, we offer standard 1/2/3/5/10/20/25 kg per-bag options with a PE inner liner and a kraft-paper or woven outer bag; packaging materials, sizes/specifications, and labeling also can be customized on request.'
)
</script>

<style scoped>
.custom-container {
  max-width: 900px;
}

.custom-section {
  margin-top: 16px;
}

.custom-text {
  font-size: 14px;
  color: #555555;
  line-height: 1.8;
}
</style>
