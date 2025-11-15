<!-- frontend/src/views/QualityServiceView.vue -->
<template>
  <div class="page page-quality">
    <div class="container quality-container">
      <h2 class="page-title">
        {{ currentLang === 'zh' ? '质量与服务' : 'Quality & Service' }}
      </h2>

      <!-- 短版介绍，柔和背景 -->
      <section class="quality-section section-card section-card--soft">
        <p class="quality-text">
          {{ shortIntro }}
        </p>
      </section>

      <!-- 标语，强调边框 -->
      <section class="quality-section section-card section-card--accent-border">
        <h3 class="quality-tagline">
          {{
            currentLang === 'zh'
              ? '以质立企，以服致远——金米莱的承诺与坚守'
              : 'Built on Quality, Guided by Service — Jinmilai’s Commitment and Resolve'
          }}
        </h3>
      </section>

      <!-- 长文案 -->
      <section class="quality-section section-card">
        <p
          v-for="(para, index) in longParas"
          :key="index"
          class="quality-text"
        >
          {{ para }}
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

// 短版质量与服务介绍
const shortIntro = computed(() =>
  currentLang.value === 'zh'
    ? '金米莱坚持以质量与交付为先，完善原料准入、过程监控与成品放行体系；目前 80% 以上产品出口至东南亚、非洲、中东、欧美等市场。依托成熟的报检与合规流程，我们为客户提供高效的国际交付与响应式服务，缩短出口环节周期，稳定供货体验。'
    : 'Quality and delivery are our priorities. With robust incoming controls, in-process monitoring, and release procedures, over 80% of our shipments serve markets across Southeast Asia, Africa, the Middle East, Europe, and the Americas. Our streamlined export-compliance workflow enables responsive service and reliable lead times for a consistently smooth customer experience.'
)

// 长文案：质量 + 服务 + 用户价值
const longParas = computed(() => {
  if (currentLang.value === 'zh') {
    return [
      '对我们而言，“质量”从来不是一句口号，而是刻在生产与运营每一个环节的准则。从原材料的严格甄选，到生产流程的精密管控，再到成品出厂前的层层检验，我们拒绝“差不多”，追求“零瑕疵”。因为我们深知，每一包产品都承载着用户的期待，唯有以“质量为本”的匠心打磨，以“质量至上”的标准苛求，才能让产品成为信任的载体，让品牌在市场中拥有真正的底气。',
      '而“服务”，是我们与用户之间温暖的连接。我们不仅提供优质的产品，更致力于打造全周期的贴心服务——售前，用专业解答您的每一个疑问；售中，以高效对接保障您的需求落地；售后，凭及时响应解决您的后顾之忧。我们相信，好的服务能让产品更有温度，能让合作不止于交易，更能成为长久相伴的基石。',
      '从“做好产品”到“做好服务”，我们始终以用户为中心，用质量筑牢根基，用服务传递价值。选择金米莱，您收获的不仅是一份优质产品，更是一份安心无忧的合作承诺。'
    ]
  }
  return [
    'For us, “quality” has never been a slogan—it is the rule embedded in every link of production and operations. From rigorous raw-material selection and precise process control to multi-stage inspections before shipment, we reject “good enough” and pursue “zero defects.” We understand that every bag carries a customer’s expectations. Only by honing our work with a quality-first craftsmanship and holding ourselves to a quality-above-all standard can our products become a trusted choice and our brand earn real credibility in the market.',
    '“Service” is the warm connection between us and our customers. Beyond delivering premium products, we are committed to a thoughtful, end-to-end service experience: before sale, our specialists answer every question; during fulfillment, efficient coordination ensures your requirements are executed; after sale, prompt responses remove any concerns. We believe good service gives products warmth, transforms transactions into cooperation, and lays the foundation for long-term partnership.',
    'From “making better products” to “delivering better service,” we remain customer-centric—building a solid foundation with quality and conveying value through service. Choose Jinmilai, and you gain not only a superior product, but also a partnership defined by assurance and peace of mind.'
  ]
})
</script>

<style scoped>
.quality-container {
  max-width: 900px;
}

.quality-section {
  margin-top: 16px;
}

.quality-text {
  font-size: 14px;
  color: #555555;
  line-height: 1.9;
  margin: 0 0 10px;
}

.quality-tagline {
  font-size: 18px;
  margin: 8px 0;
  color: #333333;
}
</style>
