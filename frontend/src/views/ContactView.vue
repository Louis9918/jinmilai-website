<!-- frontend/src/views/ContactView.vue -->
<template>
  <div class="page page-contact">
    <div class="container contact-container">
      <h2 class="page-title">
        {{ currentLang === 'zh' ? '联系我们' : 'Contact Us' }}
      </h2>

      <!-- 顶部信息卡片：左侧公司信息 + 右侧标语 -->
      <section
        class="section-card section-card--soft contact-hero-card"
      >
        <div class="contact-hero-grid">
          <div class="contact-info-block">
            <h3 class="section-subtitle">
              {{
                currentLang === 'zh'
                  ? '江苏金米莱生物科技有限公司'
                  : 'JIANGSU JINMILAI BIOTECH CO., LTD.'
              }}
            </h3>
            <p class="contact-line">
              <strong>{{ currentLang === 'zh' ? '地址：' : 'Address: ' }}</strong>
              No. 130, Wayao Industrial Park, Xinyi City, Jiangsu Province, China
            </p>
            <p class="contact-line">
              <strong>Tel: </strong>
              +86 152 5229 9269
            </p>
            <p class="contact-line">
              <strong>Email: </strong>
              15252299269@139.com
            </p>
            <p class="contact-line">
              <strong>Website: </strong>
              www.jinmilai.com
            </p>
          </div>

          <div class="contact-hero-copy">
            <div class="hero-pill">
              {{
                currentLang === 'zh'
                  ? '全球客户 · 快速响应 · 稳定交付'
                  : 'Global Customers · Fast Response · Reliable Delivery'
              }}
            </div>
            <p class="contact-hero-text">
              {{
                currentLang === 'zh'
                  ? '无论您关注的是产品规格、样品申请还是长期合作，我们都欢迎您通过下方表单或电话、邮件与我们联系。金米莱团队将尽快与您对接，为您的应用场景提供匹配的解决方案。'
                  : 'Whether you are looking for product specifications, samples, or long-term partnership, we welcome you to reach out via the form below, phone, or email. The Jinmilai team will respond promptly and work with you to design solutions tailored to your application needs.'
              }}
            </p>
          </div>
        </div>
      </section>

      <!-- 表单卡片 -->
      <section class="section-card contact-form-card">
        <h3 class="section-subtitle">
          {{
            currentLang === 'zh'
              ? '在线留言'
              : 'Online Inquiry'
          }}
        </h3>

        <p class="contact-form-tip">
          {{
            currentLang === 'zh'
              ? '请尽可能详细地描述您的需求（产品类型、指标要求、应用场景等），我们会在工作时间尽快回复您。'
              : 'Please describe your needs in as much detail as possible (product type, specification requirements, application scenarios, etc.). We will reply as soon as possible during business hours.'
          }}
        </p>

        <form class="contact-form" @submit.prevent="handleSubmit">
          <div class="contact-grid">
            <div class="form-group">
              <label for="name">
                {{ currentLang === 'zh' ? '姓名（必填）' : 'Name (Required)' }}
              </label>
              <input
                id="name"
                v-model.trim="form.name"
                type="text"
                :placeholder="currentLang === 'zh' ? '请输入您的姓名' : 'Please enter your name'"
              />
              <p v-if="errors.name" class="form-error">
                {{ errors.name }}
              </p>
            </div>

            <div class="form-group">
              <label for="company">
                {{ currentLang === 'zh' ? '公司/单位' : 'Company' }}
              </label>
              <input
                id="company"
                v-model.trim="form.company"
                type="text"
                :placeholder="currentLang === 'zh' ? '请输入公司或单位名称（可选）' : 'Company or organization (optional)'"
              />
            </div>

            <div class="form-group">
              <label for="email">
                {{ currentLang === 'zh' ? '邮箱（必填）' : 'Email (Required)' }}
              </label>
              <input
                id="email"
                v-model.trim="form.email"
                type="email"
                :placeholder="currentLang === 'zh' ? '用于接收报价或技术资料' : 'For sending quotations or technical documents'"
              />
              <p v-if="errors.email" class="form-error">
                {{ errors.email }}
              </p>
            </div>

            <div class="form-group">
              <label for="phone">
                {{ currentLang === 'zh' ? '电话/Whatsapp' : 'Phone / Whatsapp' }}
              </label>
              <input
                id="phone"
                v-model.trim="form.phone"
                type="text"
                :placeholder="currentLang === 'zh' ? '方便我们与您进一步沟通（可选）' : 'Optional, for faster follow-up'"
              />
            </div>
          </div>

          <div class="form-group form-group-full">
            <label for="message">
              {{ currentLang === 'zh' ? '留言内容（必填）' : 'Message (Required)' }}
            </label>
            <textarea
              id="message"
              v-model.trim="form.message"
              rows="5"
              :placeholder="messagePlaceholder"
            />
            <p v-if="errors.message" class="form-error">
              {{ errors.message }}
            </p>
          </div>

          <div class="form-actions">
            <button
              class="btn btn-primary"
              type="submit"
              :disabled="submitting"
            >
              <span v-if="!submitting">
                {{ currentLang === 'zh' ? '提交' : 'Submit' }}
              </span>
              <span v-else>
                {{ currentLang === 'zh' ? '提交中...' : 'Submitting...' }}
              </span>
            </button>

            <p
              v-if="submitStatus === 'success'"
              class="form-feedback form-feedback--success"
            >
              {{
                currentLang === 'zh'
                  ? '您的信息已提交成功，我们会尽快与您联系。'
                  : 'Your message has been submitted successfully. We will contact you shortly.'
              }}
            </p>
            <p
              v-if="submitStatus === 'error'"
              class="form-feedback form-feedback--error"
            >
              {{
                currentLang === 'zh'
                  ? '提交失败，请稍后重试或通过电话、邮件联系我们。'
                  : 'Submission failed. Please try again later or contact us by phone or email.'
              }}
            </p>
          </div>
        </form>
      </section>
    </div>
  </div>
</template>

<script setup>
import { reactive, ref, computed } from 'vue'
import { useRoute } from 'vue-router'

const route = useRoute()

const currentLang = computed(() =>
  route.params.lang === 'en' ? 'en' : 'zh'
)

const form = reactive({
  name: '',
  company: '',
  email: '',
  phone: '',
  message: ''
})

const errors = reactive({
  name: '',
  email: '',
  message: ''
})

const submitting = ref(false)
const submitStatus = ref(null) // 'success' | 'error' | null

const messagePlaceholder = computed(() =>
  currentLang.value === 'zh'
    ? '例如：目标产品（复合氨基酸原粉/蛋白粉/蛋白胨等）、规格要求（含量、总氮、水分等）、应用场景（肥料、饲料、培养基、食品等）、预计采购量与交期等。'
    : 'For example: target product (compound amino acid powders / protein hydrolysate / peptone, etc.), specification requirements (content, total nitrogen, moisture, etc.), application scenarios (fertilizer, feed, culture medium, food, etc.), estimated order volume and lead time.'
)

function validate() {
  let ok = true
  errors.name = ''
  errors.email = ''
  errors.message = ''

  if (!form.name) {
    errors.name =
      currentLang.value === 'zh' ? '请输入姓名' : 'Please enter your name'
    ok = false
  }

  if (!form.email) {
    errors.email =
      currentLang.value === 'zh'
        ? '请输入邮箱'
        : 'Please enter your email address'
    ok = false
  } else {
    const pattern = /^[^\s@]+@[^\s@]+\.[^\s@]+$/
    if (!pattern.test(form.email)) {
      errors.email =
        currentLang.value === 'zh'
          ? '邮箱格式不正确'
          : 'Invalid email format'
      ok = false
    }
  }

  if (!form.message) {
    errors.message =
      currentLang.value === 'zh'
        ? '请输入留言内容'
        : 'Please enter your message'
    ok = false
  }

  return ok
}

async function handleSubmit() {
  submitStatus.value = null

  if (!validate()) {
    return
  }

  submitting.value = true

  try {
    const response = await fetch('/api/contact', {
      method: 'POST',
      headers: {
        'Content-Type': 'application/json'
      },
      body: JSON.stringify({
        name: form.name,
        company: form.company,
        email: form.email,
        phone: form.phone,
        message: form.message,
        preferredLanguage: currentLang.value
      })
    })

    if (!response.ok) {
      submitStatus.value = 'error'
      return
    }

    // const data = await response.json() // 需要的话可以打印
    submitStatus.value = 'success'

    // 提交成功后清空表单
    form.name = ''
    form.company = ''
    form.email = ''
    form.phone = ''
    form.message = ''
  } catch (e) {
    console.error('Contact submit error', e)
    submitStatus.value = 'error'
  } finally {
    submitting.value = false
  }
}
</script>

<style scoped>
.contact-container {
  max-width: 900px;
}

.contact-hero-card {
  margin-top: 12px;
}

.contact-hero-grid {
  display: flex;
  gap: 24px;
  align-items: flex-start;
}

.contact-info-block {
  flex: 1;
  min-width: 0;
}

.contact-hero-copy {
  flex: 1.1;
  min-width: 0;
}

.contact-line {
  font-size: 14px;
  color: #555555;
  line-height: 1.6;
  margin: 2px 0;
}

.contact-hero-text {
  margin-top: 8px;
  font-size: 14px;
  color: #555555;
  line-height: 1.8;
}

/* 表单 */
.contact-form-card {
  margin-top: 20px;
}

.contact-form-tip {
  font-size: 13px;
  color: #777777;
  margin: 4px 0 12px;
}

.contact-form {
  margin-top: 6px;
}

.contact-grid {
  display: grid;
  grid-template-columns: repeat(2, minmax(0, 1fr));
  gap: 16px;
}

.form-group {
  display: flex;
  flex-direction: column;
  font-size: 14px;
}

.form-group-full {
  margin-top: 12px;
}

label {
  margin-bottom: 4px;
  color: #333333;
}

input,
textarea {
  border-radius: 10px;
  border: 1px solid var(--color-border-light);
  padding: 8px 10px;
  font-size: 14px;
  font-family: inherit;
  outline: none;
  transition: border-color 0.15s ease, box-shadow 0.15s ease,
    background-color 0.15s ease;
}

input:focus,
textarea:focus {
  border-color: rgba(243, 112, 33, 0.9);
  box-shadow: 0 0 0 1px rgba(243, 112, 33, 0.25);
  background-color: #fffdf9;
}

textarea {
  resize: vertical;
  min-height: 120px;
}

.form-error {
  margin-top: 4px;
  font-size: 12px;
  color: #d93025;
}

.form-actions {
  margin-top: 16px;
  display: flex;
  flex-wrap: wrap;
  align-items: center;
  gap: 12px;
}

.btn[disabled] {
  opacity: 0.7;
  cursor: default;
}

.form-feedback {
  font-size: 13px;
}

.form-feedback--success {
  color: #1a7f37;
}

.form-feedback--error {
  color: #d93025;
}

@media (max-width: 768px) {
  .contact-hero-grid {
    flex-direction: column;
  }

  .contact-grid {
    grid-template-columns: 1fr;
  }
}
</style>
