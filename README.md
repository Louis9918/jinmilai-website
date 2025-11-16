# Jinmilai Website · 江苏金米莱官网

基于 **Spring Boot (Java 17) + Vue 3 + Vite** 搭建的江苏金米莱生物科技有限公司官网，用于对外展示公司形象、产品与应用、质量与服务、定制与包装，以及提供在线「联系我们」通道（带邮件通知）。

- 主题色：`#f37021`
- 字体：正文采用「宋体 / SimSun」风格
- 支持 **中英文双语** 页面：`/zh/...` 与 `/en/...`
- 适配 **PC + 移动端**（响应式布局）
- 联系我们表单支持调用后端 `/api/contact` 并通过 **QQ 邮箱** 发送通知邮件

---

## 1. 技术栈 / Tech Stack

**后端 (backend)**

- Java 17
- Spring Boot
- Spring Web
- Spring Validation (`spring-boot-starter-validation`)
- Spring Mail (`spring-boot-starter-mail`)
- Maven

**前端 (frontend)**

- Vue 3
- Vite
- Vue Router
- 原生 CSS（自定义响应式布局 + 主题色）

---

## 2. 功能概览 / Features

### 2.1 页面与导航

- 顶部导航栏（含 Logo 图片 + 中英文字标识）
- 中 / EN 语言切换（保留当前页面路径）
- 移动端汉堡菜单（小屏设备自动切换为下拉导航）

主要页面路由（均支持 `zh` / `en`）：

- `/zh` / `/en`：首页 Home
- `/zh/company` / `/en/company`：公司概况 Company Profile
- `/zh/products` / `/en/products`：产品与应用 Products & Applications
- `/zh/quality` / `/en/quality`：质量与服务 Quality & Service
- `/zh/custom` / `/en/custom`：定制与包装 Custom Specifications & Packaging
- `/zh/contact` / `/en/contact`：联系我们 Contact Us

### 2.2 首页 Home

- 左侧品牌文案 + 行业标语
- 右侧 **大图轮播 Hero**（农业 / 实验室 / 物流等主题图）
- 公司概况 / 产品与应用简要介绍
- 关键数字卡片：
  - 成立年份（2021）
  - 注册资本（1100 万元）
  - 厂区面积（约 60,000 m²）
  - 出口占比（80%+）

### 2.3 内页内容

- **公司概况**：公司简介 + 核心优势（自有实验室、质量检测中心、80%+ 出口等）
- **产品与应用**：
  - 复合氨基酸原粉（含游离氨基酸 / 总氮 / 水分 / pH / 水溶性规格表）
  - 植物源氨基酸原粉
  - 蛋白粉（Protein Hydrolysate Powder 指标表）
  - 蛋白胨培养基（Peptone Culture Medium 指标表）
- **质量与服务**：
  - 短版质量与服务说明（报检流程、国际交付）
  - 标语「以质立企，以服致远」
  - 长文案：质量理念 + 服务理念 + 用户价值
- **定制与包装**：
  - 配方定制：氨基酸 / 蛋白含量 + Fe / Zn / Mn / Cu / B / Mo / Mg / K 等微 / 常量元素
  - 包装规格：1 / 2 / 3 / 5 / 10 / 20 / 25 kg/袋，内袋 PE，外袋牛皮纸或编织袋，支持材质 / 规格 / 标识定制

所有主内容区均采用统一的 **卡片式布局**（圆角 + 阴影 + 渐变背景），兼顾 PC 与移动端视觉效果。

### 2.4 联系我们 Contact

- 上方信息卡片：
  - 公司中英文名称
  - 地址、Tel、Email、官网
  - 品牌标语（全球客户 / 快速响应 / 稳定交付）
- 下方在线咨询表单：
  - 姓名（必填）
  - 公司 / 单位（选填）
  - 邮箱（必填，带前后端格式校验）
  - 电话 / Whatsapp（选填）
  - 留言内容（必填，支持详细描述产品、指标、应用场景、采购量等）
- 前端校验 + 提交状态反馈：
  - 校验失败：在对应字段下展示错误信息
  - 提交成功：提示「已提交成功」
  - 提交失败：提示「提交失败，请稍后重试或通过电话、邮件联系我们」
- 后端 API：
  - `POST /api/contact`
  - 入参：`ContactRequest` DTO（带校验注解）
  - 返回：`ContactResponse { success, message }`
  - 日志记录 + QQ 邮箱通知邮件

---

## 3. 项目结构 / Project Structure

仓库结构示例：

```text
.
├─ backend/                    # Spring Boot 后端
│  ├─ src/main/java/com/jinmilai/backend/
│  │  ├─ controller/
│  │  │  └─ ContactController.java
│  │  ├─ dto/
│  │  │  ├─ ContactRequest.java
│  │  │  └─ ContactResponse.java
│  │  ├─ service/
│  │  │  └─ ContactNotificationService.java
│  │  └─ config/
│  │     └─ CorsConfig.java
│  └─ src/main/resources/
│     └─ application.properties (或 application.yml)
│
└─ frontend/                   # Vue 3 + Vite 前端
   ├─ src/
   │  ├─ assets/
   │  │  ├─ main.css
   │  │  ├─ logo-jml.png
   │  │  ├─ hero-plant.jpg
   │  │  ├─ hero-lab.jpg
   │  │  └─ hero-logistics.jpg
   │  ├─ components/
   │  │  └─ layout/
   │  │     ├─ MainHeader.vue
   │  │     └─ MainFooter.vue
   │  ├─ views/
   │  │  ├─ HomeView.vue
   │  │  ├─ CompanyProfileView.vue
   │  │  ├─ ProductsView.vue
   │  │  ├─ QualityServiceView.vue
   │  │  ├─ CustomPackagingView.vue
   │  │  └─ ContactView.vue
   │  ├─ router/
   │  │  └─ index.js
   │  ├─ App.vue
   │  └─ main.js
   └─ vite.config.js
```

---

## 4. 环境准备 / Prerequisites

- **Java 17**
- **Maven 3.8+**
- **Node.js 18+**（建议）
- **npm / pnpm / yarn**（示例使用 npm）
- 已开通支持 SMTP 的 **QQ 邮箱**（用于接收「联系我们」通知）

---

## 5. 后端启动 · Backend

### 5.1 Contact 相关核心类（包路径示例）

> 包路径统一使用 `com.jinmilai.backend` 作为根包名。

**DTO：ContactRequest**

```java
package com.jinmilai.backend.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class ContactRequest {

    @NotBlank(message = "Name is required")
    @Size(max = 100)
    private String name;

    @Size(max = 200)
    private String company;

    @NotBlank(message = "Email is required")
    @Email(message = "Invalid email format")
    @Size(max = 120)
    private String email;

    @Size(max = 50)
    private String phone;

    @NotBlank(message = "Message is required")
    @Size(max = 2000)
    private String message;

    @Size(max = 10)
    private String preferredLanguage;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getPreferredLanguage() {
        return preferredLanguage;
    }

    public void setPreferredLanguage(String preferredLanguage) {
        this.preferredLanguage = preferredLanguage;
    }
}
```

**DTO：ContactResponse**

```java
package com.jinmilai.backend.dto;

public class ContactResponse {

    private boolean success;
    private String message;

    public ContactResponse() {
    }

    public ContactResponse(boolean success, String message) {
        this.success = success;
        this.message = message;
    }

    public static ContactResponse ok(String message) {
        return new ContactResponse(true, message);
    }

    public static ContactResponse fail(String message) {
        return new ContactResponse(false, message);
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
```

**Service：ContactNotificationService（发送通知邮件）**

```java
package com.jinmilai.backend.service;

import com.jinmilai.backend.dto.ContactRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Service
public class ContactNotificationService {

    private static final Logger log = LoggerFactory.getLogger(ContactNotificationService.class);

    private final JavaMailSender mailSender;
    private final String notifyTo;
    private final String fromAddress;
    private final String subjectPrefix;

    public ContactNotificationService(
            JavaMailSender mailSender,
            @Value("${jinmilai.contact.notify-to}") String notifyTo,
            @Value("${spring.mail.username}") String fromAddress,
            @Value("${jinmilai.contact.notify-subject-prefix:New contact from Jinmilai website}") String subjectPrefix
    ) {
        this.mailSender = mailSender;
        this.notifyTo = notifyTo;
        this.fromAddress = fromAddress;
        this.subjectPrefix = subjectPrefix;
    }

    public boolean sendContactEmail(ContactRequest request) {
        try {
            SimpleMailMessage message = new SimpleMailMessage();

            message.setFrom(fromAddress);
            message.setTo(notifyTo);

            String now = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
            String lang = request.getPreferredLanguage() == null ? "" : request.getPreferredLanguage().toUpperCase();

            String subject = subjectPrefix + " [" + now + "]";
            message.setSubject(subject);

            StringBuilder body = new StringBuilder();
            body.append("New contact message from Jinmilai website").append("

");
            body.append("Time: ").append(now).append("
");
            body.append("Preferred Language: ").append(lang).append("

");
            body.append("Name: ").append(nullSafe(request.getName())).append("
");
            body.append("Company: ").append(nullSafe(request.getCompany())).append("
");
            body.append("Email: ").append(nullSafe(request.getEmail())).append("
");
            body.append("Phone: ").append(nullSafe(request.getPhone())).append("
");
            body.append("Message:
").append(nullSafe(request.getMessage())).append("
");

            message.setText(body.toString());

            mailSender.send(message);

            log.info("Contact notification email sent to {}", notifyTo);
            return true;
        } catch (Exception e) {
            log.error("Failed to send contact notification email", e);
            return false;
        }
    }

    private String nullSafe(String v) {
        return v == null ? "" : v;
    }
}
```

**Controller：ContactController**

```java
package com.jinmilai.backend.controller;

import com.jinmilai.backend.dto.ContactRequest;
import com.jinmilai.backend.dto.ContactResponse;
import com.jinmilai.backend.service.ContactNotificationService;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/contact")
public class ContactController {

    private static final Logger log = LoggerFactory.getLogger(ContactController.class);

    private final ContactNotificationService contactNotificationService;

    public ContactController(ContactNotificationService contactNotificationService) {
        this.contactNotificationService = contactNotificationService;
    }

    @PostMapping
    public ResponseEntity<ContactResponse> submitContact(
            @Valid @RequestBody ContactRequest request,
            BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            String errorMsg = bindingResult.getAllErrors().get(0).getDefaultMessage();
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(ContactResponse.fail(errorMsg));
        }

        log.info("New contact message from website: name={}, company={}, email={}, phone={}, lang={}",
                request.getName(),
                request.getCompany(),
                request.getEmail(),
                request.getPhone(),
                request.getPreferredLanguage());

        boolean emailSent = contactNotificationService.sendContactEmail(request);

        String okMsg;
        if (emailSent) {
            okMsg = "Contact message received and notification email sent";
        } else {
            okMsg = "Contact message received, but failed to send notification email";
        }

        return ResponseEntity.ok(ContactResponse.ok(okMsg));
    }
}
```

**CORS 配置（允许本地前端访问 /api）**

```java
package com.jinmilai.backend.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class CorsConfig {

    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/api/**")
                        .allowedOrigins(
                                "http://localhost:5173",
                                "http://127.0.0.1:5173"
                        )
                        .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS")
                        .allowedHeaders("*")
                        .allowCredentials(false);
            }
        };
    }
}
```

### 5.2 配置 QQ 邮箱 SMTP

在 `backend/src/main/resources/application.properties` 中配置 QQ SMTP（推荐 587 + STARTTLS）：

```properties
# ========== QQ 邮箱 SMTP ==========
spring.mail.host=smtp.qq.com
spring.mail.port=587
spring.mail.username=你的QQ邮箱@qq.com
spring.mail.password=你的QQ邮箱SMTP授权码  # 注意：不是登录密码，是“授权码”

spring.mail.default-encoding=UTF-8
spring.mail.properties.mail.smtp.auth=true
spring.mail.properties.mail.smtp.starttls.enable=true

# ========== 联系我们通知配置 ==========
jinmilai.contact.notify-to=你的接收邮箱@example.com
jinmilai.contact.notify-subject-prefix=New contact from Jinmilai website
```

> 授权码获取方式：登录 QQ 邮箱 → 设置 → 账户 → 开启 POP3/SMTP 服务 → 根据提示获取授权码。

如 587 端口受限，可改用 465 + SSL：

```properties
spring.mail.host=smtp.qq.com
spring.mail.port=465
spring.mail.username=你的QQ邮箱@qq.com
spring.mail.password=你的QQ邮箱SMTP授权码
spring.mail.default-encoding=UTF-8

spring.mail.properties.mail.smtp.auth=true
spring.mail.properties.mail.smtp.ssl.enable=true
```

### 5.3 启动后端

```bash
cd backend
./mvnw spring-boot:run
# 或
mvn spring-boot:run
```

默认监听：`http://localhost:8080`

---

## 6. 前端启动 · Frontend

### 6.1 安装依赖

```bash
cd frontend
npm install
```

### 6.2 Vite 开发代理

在 `frontend/vite.config.js` 中配置 `/api` 代理到后端：

```js
import { fileURLToPath, URL } from 'node:url'
import { defineConfig } from 'vite'
import vue from '@vitejs/plugin-vue'

export default defineConfig({
  plugins: [vue()],
  resolve: {
    alias: {
      '@': fileURLToPath(new URL('./src', import.meta.url))
    }
  },
  server: {
    proxy: {
      '/api': {
        target: 'http://localhost:8080',
        changeOrigin: true
      }
    }
  }
})
```

### 6.3 启动前端

```bash
npm run dev
```

默认访问：`http://localhost:5173`

- 中文首页：`http://localhost:5173/zh`
- 英文首页：`http://localhost:5173/en`
- 联系我们：`http://localhost:5173/zh/contact` / `/en/contact`

---

## 7. 构建与部署 · Build & Deploy

### 7.1 前端构建

```bash
cd frontend
npm run build
```

构建产物在 `frontend/dist/`，可通过 Nginx / 静态服务器托管，也可以整合进 Spring Boot 的静态资源（如 `backend/src/main/resources/static`），具体视部署策略而定。

### 7.2 后端打包

```bash
cd backend
mvn clean package
```

生成可执行 Jar（例如 `target/jinmilai-website-0.0.1-SNAPSHOT.jar`）：

```bash
java -jar target/jinmilai-website-0.0.1-SNAPSHOT.jar
```

---

## 8. 后续计划 / TODO

- 产品页增加实际产品图片 & 图标（按品类分块展示）
- 「联系我们」支持附件上传（如指标需求表 / 规格单）
- 支持将表单数据写入数据库（MySQL + JPA）方便内部管理
- 完善英文版 SEO 文案（Title / Description / Meta）
- 接入简单访问统计 / 埋点

---

## 9. English Quick Start (Brief)

**Backend**

1. Configure `application.properties` with QQ SMTP:

```properties
spring.mail.host=smtp.qq.com
spring.mail.port=587
spring.mail.username=your_qq_email@qq.com
spring.mail.password=your_smtp_authorization_code
spring.mail.properties.mail.smtp.auth=true
spring.mail.properties.mail.smtp.starttls.enable=true

jinmilai.contact.notify-to=your_receive_email@example.com
jinmilai.contact.notify-subject-prefix=New contact from Jinmilai website
```

2. Run backend:

```bash
cd backend
mvn spring-boot:run
```

**Frontend**

1. Install & run:

```bash
cd frontend
npm install
npm run dev
```

2. Open:

- `http://localhost:5173/zh` – Chinese site  
- `http://localhost:5173/en` – English site  

Use the **Contact Us** page to send a test inquiry and confirm that email notifications are working.