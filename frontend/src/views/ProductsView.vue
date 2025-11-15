<!-- frontend/src/views/ProductsView.vue -->
<template>
  <div class="page page-products">
    <div class="container">
      <h2 class="page-title">
        {{ currentLang === 'zh' ? '产品与应用' : 'Products & Applications' }}
      </h2>

      <!-- 顶部介绍 -->
      <section class="product-section section-card section-card--soft">
        <p class="product-intro">
          {{ productsIntro }}
        </p>
      </section>

      <!-- 复合氨基酸原粉 -->
      <section class="product-section section-card">
        <h3 class="product-title">
          {{ currentLang === 'zh' ? '复合氨基酸原粉' : 'Compound Amino Acid Powder' }}
          <small> / Compound Amino Acid Powder</small>
        </h3>
        <p class="product-text">
          {{ compoundAminoText }}
        </p>

        <div class="table-wrapper">
          <table class="spec-table">
            <thead>
              <tr>
                <th>游离氨基酸 (Free Amino Acids)</th>
                <th>总氮 (Total Nitrogen)</th>
                <th>水分 (Moisture)</th>
                <th>pH</th>
                <th>水溶性 (Water Solubility)</th>
              </tr>
            </thead>
            <tbody>
              <tr>
                <td>40%</td>
                <td>17%</td>
                <td>3%</td>
                <td>4 - 8</td>
                <td>全水溶 / Fully water-soluble</td>
              </tr>
              <tr>
                <td>50%</td>
                <td>16%</td>
                <td>3%</td>
                <td>4 - 8</td>
                <td>全水溶 / Fully water-soluble</td>
              </tr>
              <tr>
                <td>80%</td>
                <td>12%</td>
                <td>3%</td>
                <td>4 - 8</td>
                <td>全水溶 / Fully water-soluble</td>
              </tr>
            </tbody>
          </table>
        </div>
      </section>

      <!-- 植物源氨基酸原粉 -->
      <section class="product-section section-card">
        <h3 class="product-title">
          {{ currentLang === 'zh' ? '植物源氨基酸原粉' : 'Plant-derived Amino Acid Powder' }}
          <small> / Plant-derived Amino Acid Powder</small>
        </h3>
        <p class="product-text">
          {{ plantAminoText }}
        </p>
      </section>

      <!-- 蛋白粉 / Protein Hydrolysate Powder -->
      <section class="product-section section-card">
        <h3 class="product-title">
          {{ currentLang === 'zh' ? '蛋白粉' : 'Protein Hydrolysate Powder' }}
          <small> / Protein Hydrolysate Powder</small>
        </h3>
        <p class="product-text">
          {{ proteinText }}
        </p>

        <div class="table-wrapper">
          <table class="spec-table">
            <thead>
              <tr>
                <th>指标 (Item)</th>
                <th>含量 / 典型值 (Specification)</th>
                <th>Item (EN)</th>
                <th>Specification (EN)</th>
              </tr>
            </thead>
            <tbody>
              <tr>
                <td>氨基酸含量</td>
                <td>90%</td>
                <td>Amino Acid Content</td>
                <td>90%</td>
              </tr>
              <tr>
                <td>蛋白含量</td>
                <td>92%</td>
                <td>Protein Content</td>
                <td>92%</td>
              </tr>
              <tr>
                <td>总氮</td>
                <td>14%</td>
                <td>Total Nitrogen</td>
                <td>14%</td>
              </tr>
              <tr>
                <td>水分</td>
                <td>3%</td>
                <td>Moisture</td>
                <td>3%</td>
              </tr>
              <tr>
                <td>水溶性</td>
                <td>全水溶</td>
                <td>Water Solubility</td>
                <td>Fully water-soluble</td>
              </tr>
            </tbody>
          </table>
        </div>
      </section>

      <!-- 蛋白胨培养基 -->
      <section class="product-section section-card">
        <h3 class="product-title">
          {{ currentLang === 'zh' ? '蛋白胨培养基' : 'Peptone Culture Medium' }}
          <small> / Peptone Culture Medium</small>
        </h3>
        <p class="product-text">
          {{ peptoneText }}
        </p>

        <div class="table-wrapper">
          <table class="spec-table">
            <thead>
              <tr>
                <th>指标 (Item)</th>
                <th>典型值 (Specification)</th>
                <th>Item (EN)</th>
                <th>Specification (EN)</th>
              </tr>
            </thead>
            <tbody>
              <tr>
                <td>外观</td>
                <td>浅黄色粉末</td>
                <td>Appearance</td>
                <td>Light yellow powder</td>
              </tr>
              <tr>
                <td>肽氮</td>
                <td>≥ 5%</td>
                <td>Peptide Nitrogen</td>
                <td>≥ 5%</td>
              </tr>
              <tr>
                <td>水分</td>
                <td>≤ 5%</td>
                <td>Moisture</td>
                <td>≤ 5%</td>
              </tr>
              <tr>
                <td>总氮</td>
                <td>≥ 10%</td>
                <td>Total Nitrogen</td>
                <td>≥ 10%</td>
              </tr>
              <tr>
                <td>溶解性</td>
                <td>完全可溶</td>
                <td>Water Solubility</td>
                <td>Fully water-soluble</td>
              </tr>
            </tbody>
          </table>
        </div>
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

// 顶部“产品与应用”简介
const productsIntro = computed(() =>
  currentLang.value === 'zh'
    ? '公司以羽毛蛋白等为来源生产氨基酸，核心产品包括胱氨酸、亮氨酸、酪氨酸，以及复合氨基酸粉系列。产品广泛用于医药、食品、化妆品，以及生化与营养学研究等领域；同时可提供规格定制、配方建议与技术支持，协助客户从打样验证顺利迈向规模化生产。'
    : 'We leverage feather-derived proteins to produce L-Cystine, L-Leucine, L-Tyrosine, and a portfolio of compound amino acid powders. Applications span pharmaceuticals, food & beverage, cosmetics, and biochemical/nutrition research. We also provide customized specifications, formulation advice, and technical support to bridge pilot trials and full-scale manufacturing.'
)

// 各产品介绍
const compoundAminoText = computed(() =>
  currentLang.value === 'zh'
    ? '氨基酸原粉采用氨基酸溶液喷雾干燥工艺制成，最大程度保留营养成分。产品由多种氨基酸科学复配而成，可定制无氯型配方，广泛适用于植物营养、饲料及发酵领域。产品富含氨基酸、氮和有机质，可直接作为肥料使用，适用于冲施、喷施等多种方式，促进作物生长，效果显著。根据不同地区和作物的营养需求，可按测土配方科学添加磷、钾及铁、锌、硼、锰、钼、铜等微量元素，制成全营养、功能型肥料。氨基酸原粉亦是滴灌肥、冲施肥、水溶肥等高品质功能性肥料的理想载体。'
    : 'Amino Acid Powder is produced by spray-drying premium amino acid solution, effectively preserving its full nutritional value. Formulated from a balanced combination of multiple amino acids, it can be customized into chloride-free types and is widely applicable in plant nutrition, animal feed, and fermentation formulas. Rich in amino acids, nitrogen, and organic matter, it can be directly used as fertilizer through fertigation or foliar application, delivering remarkable results in crop growth and yield. Tailored to regional soils and crop needs, essential nutrients such as phosphorus and potassium, together with micronutrients including iron, zinc, boron, manganese, molybdenum, and copper, can be precisely incorporated to create balanced, full-spectrum fertilizers. It also serves as an ideal base ingredient for high-quality drip irrigation, fertigation, and water-soluble fertilizer formulations.'
)

const plantAminoText = computed(() =>
  currentLang.value === 'zh'
    ? '植物源氨基酸原粉以大豆、玉米等植物原料经酶解并喷雾干燥制成，气味更温和。'
    : 'Plant-origin amino acid base powder is produced from plant materials such as soybean and corn through enzymatic hydrolysis followed by spray drying, resulting in a milder, more neutral odor profile.'
)

const proteinText = computed(() =>
  currentLang.value === 'zh'
    ? '蛋白粉采用蛋白水解工艺制得，富含小分子肽与游离氨基酸，易吸收、易与微量元素络合。广泛应用于饲料、原料、培养基和肥料等领域中。'
    : 'The protein powder is produced through enzymatic protein hydrolysis, yielding a hydrolysate rich in low-molecular-weight peptides and free amino acids. It is readily absorbed and readily chelates with trace elements. Widely used in animal feed, as a functional raw material, in culture media, and in fertilizer formulations.'
)

const peptoneText = computed(() =>
  currentLang.value === 'zh'
    ? '蛋白胨培养基适用于发酵、微生物培养和工艺放大的通用型复合培养基粉，提供均衡的碳源、氮源与生长因子。'
    : 'Peptone culture medium is a general-purpose complex medium powder for fermentation, microbial cultivation, and process scale-up, providing a balanced supply of carbon and nitrogen sources along with essential growth factors.'
)
</script>

<style scoped>
.product-section {
  margin-top: 20px;
}

.product-intro,
.product-text {
  font-size: 14px;
  color: #555555;
  line-height: 1.8;
}

.product-title {
  font-size: 18px;
  margin: 8px 0 6px;
  color: #333333;
}

.product-title small {
  font-size: 13px;
  color: #888888;
  margin-left: 4px;
}

/* 表格容器：小屏幕可以横向滚动 */
.table-wrapper {
  margin-top: 10px;
  overflow-x: auto;
}

.spec-table {
  width: 100%;
  border-collapse: collapse;
  font-size: 13px;
  min-width: 480px;
}

.spec-table th,
.spec-table td {
  border: 1px solid var(--color-border-light);
  padding: 8px 6px;
  text-align: center;
}

.spec-table th {
  background-color: #fafafa;
  font-weight: 600;
}

@media (max-width: 768px) {
  .product-title {
    font-size: 16px;
  }

  .spec-table {
    font-size: 12px;
  }
}
</style>
