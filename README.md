# Xingyu-Lab

> Java 是我的起点，AI 是我的下一站。

Xingyu-Lab 是杨兴宇的个人网站项目，也是一个长期演进的个人数字空间、技术实验室、内容沉淀平台和 AI 应用开发练习项目。

本项目不是一个普通的个人主页，而是希望逐步建设成一个可以长期使用、持续迭代、可部署上线、可沉淀为个人技术框架的完整全栈项目。

---

## 项目定位

Xingyu-Lab 的核心定位是：

```text
一个 Java 开发者转型 AI 开发工程师的个人数字空间。
```

未来它会包含：

- 个人官网
- 技术博客
- 日记空间
- 照片墙
- 资料库
- 文件中心
- 技术实验室
- 作品集
- 情侣空间
- AI 个人助手

---

## 作者背景

项目作者：杨兴宇

作者是 Java 开发出身，熟悉 Spring Boot、后端接口开发、数据库和服务器部署。随着 AI 发展，正在逐步向 AI 开发工程师转型。

使用过的 AI 工具和模型包括：

- ChatGPT
- Codex
- Claude
- Minimax
- Kimi
- DeepSeek
- Xiaomi MiMo

本项目会作为一个长期项目，用来记录作者从 Java 开发者向 AI 开发工程师转型的过程。

---

## 项目名称说明

```text
网站品牌名：Xingyu Lab
GitHub 仓库名：Xingyu-Lab
后端模块名：xingyu-lab-backend
前端模块名：xingyu-lab-frontend
Java 基础包名：com.yangxingyu.xingyulab
数据库名：xingyu_lab
```

未来可能使用的域名：

```text
yangxingyu.com
yangxingyu.cn
```

---

## 技术栈

### 后端

- Java 17+
- Spring Boot 3
- Maven 多模块
- MyBatis Plus
- Sa-Token 或 Spring Security
- MySQL / PostgreSQL
- Redis
- Knife4j / OpenAPI

### 前端

- Vue 3
- TypeScript
- Vite 或 Nuxt 3
- Pinia
- Vue Router
- Element Plus / Naive UI
- Tailwind CSS

### 部署

- Linux
- Docker
- Docker Compose
- Nginx
- HTTPS / SSL

### AI 能力

- Xiaomi MiMo API
- OpenAI 兼容接口
- Prompt 管理
- AI 对话
- RAG 知识库问答
- Embedding
- 向量数据库后期接入

---

## 项目结构规划

```text
Xingyu-Lab
├── xingyu-lab-backend       # Spring Boot 3 后端
├── xingyu-lab-frontend      # Vue 3 前端
├── docs                     # 项目文档
├── deploy                   # 部署配置
├── README.md
└── PROJECT_RULES.md
```

后端采用模块化单体架构：

```text
xingyu-lab-backend
├── pom.xml
├── xingyu-lab-start          # 启动模块
├── xingyu-lab-common         # 通用模块
├── xingyu-lab-framework      # 框架模块
├── xingyu-lab-system         # 系统模块
├── xingyu-lab-content        # 内容模块
├── xingyu-lab-media          # 媒体文件模块
├── xingyu-lab-ai             # AI 能力模块
└── xingyu-lab-lab            # 技术实验室模块
```

---

## 架构原则

后端不采用微服务，而采用：

```text
模块化单体架构 Modular Monolith
```

原则：

- 一个 Spring Boot 应用启动；
- 一个后端服务部署；
- 代码按 Maven 模块拆分；
- 模块边界清晰；
- 当前保持单体简单可维护；
- 未来可按模块逐步拆分微服务。

---

## V1.0 目标

第一阶段先做可上线版本，不追求一次性做完所有功能。

V1.0 优先实现：

- 首页
- 关于我
- 博客列表
- 博客详情
- 作品集
- 照片墙
- 后台登录
- 后台文章管理
- 分类 / 标签管理
- 图片上传
- 基础文件上传
- 内容公开 / 私密字段

---

## 给 AI 开发助手的说明

任何 AI 助手在开发本项目时，请先阅读 README 和 docs 目录下的文档。

开发要求：

1. 不要把本项目当成普通 demo；
2. 后端采用 Spring Boot 3 + Java 17 + Maven 多模块；
3. 后端是模块化单体，不是微服务；
4. 前端采用 Vue 3 + TypeScript；
5. 不要随意大规模重构目录；
6. 不要随意改变基础包名、模块名和接口返回格式；
7. 新功能应放到明确的模块中；
8. 业务模块内部按业务聚合；
9. 注意公开内容和私密内容的权限隔离；
10. 文件上传必须考虑安全性；
11. 后期要方便接入 AI 能力；
12. 复杂改动前先输出计划，不要直接大面积修改。

---

## 当前阶段

当前项目处于初始化阶段。

建议优先完成：

1. 创建后端 Maven 多模块结构；
2. 创建 Spring Boot 3 启动模块；
3. 配置统一返回结果、全局异常、基础配置；
4. 创建前端 Vue 3 项目；
5. 设计数据库基础表；
6. 实现后台登录；
7. 实现博客基础功能；
8. 实现首页和关于我页面。

---

## 项目愿景

Xingyu-Lab 最终希望成为一个长期运行的个人网站。

它要记录作者的技术、生活、项目、照片、日记、资料和成长过程。

它也要成为一个真实可用的工程项目，用来练习 Java 后端、Vue 前端、服务器部署、权限系统、文件系统、AI 接入、RAG、Agent、系统架构等能力。

最终目标：

```text
让 Xingyu-Lab 成为杨兴宇的个人数字宇宙。
```
