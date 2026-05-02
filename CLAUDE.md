# CLAUDE.md

This file provides guidance to Claude Code (claude.ai/code) when working with code in this repository.

## Project Overview

Xingyu-Lab is a full-stack personal website/digital space. It is a production project, not a demo.

## Build & Run Commands

**Backend** (from `xingyu-lab-backend/`):
```bash
mvn clean install                              # Build all modules
mvn spring-boot:run -pl xingyu-lab-start       # Run on port 8080
mvn test                                       # Run tests
mvn test -pl xingyu-lab-content                # Test single module
```

**Frontend** (from `xingyu-lab-frontend/`):
```bash
npm run dev          # Dev server on port 5173 (proxies /api to localhost:8080)
npm run build        # Type-check + production build
npm run preview      # Preview production build
```

Full stack: run backend (8080) and frontend (5173) simultaneously. Vite proxies `/api` to the backend.

## Architecture

**Modular monolith** — one Spring Boot application, code split by Maven modules.

### Backend Modules (`xingyu-lab-backend/`)

```
common       → R<T>, PageResult, BaseEntity, BusinessException, ErrorCode (no deps)
framework    → Global exception handler, MyBatis Plus config, Sa-Token config, WebMvc, OpenAPI (depends on common)
system       → User, Role, Menu, Dict, Login, Operation Log
content      → Article, Category, Tag, Comment, Diary, Resource
media        → File upload, Photo, Storage (local + MinIO)
ai           → AI chat, model config (OpenAI-compatible, currently stubbed)
lab          → Short link service (tech experiments)
start        → Spring Boot entry point + application.yaml (depends on all business modules)
```

All business modules depend on `common` + `framework`. The `start` module depends on all business modules.

### Backend Tech Stack

Java 17, Spring Boot 3.5.14, MyBatis Plus 3.5.5, Sa-Token 1.37.0, Knife4j 4.3.0, MySQL, Hutool, FastJSON2, MinIO, Lombok.

Base package: `com.yangxingyu.xingyulab`. Database: `xingyu_lab` on localhost:3306.

### Frontend (`xingyu-lab-frontend/`)

Vue 3 + TypeScript + Vite + Naive UI + Pinia + Vue Router + Tailwind CSS. Routes split into `front/` (public) and `admin/` (authenticated).

## Key Conventions

- **Unified response**: `R<T>` — `code` (200=success, 500=fail), `msg`, `data`
- **Pagination**: `PageResult<T>` — `total`, `rows`
- **Entities**: extend `BaseEntity` (snowflake id, createBy, createTime, updateBy, updateTime, logical delete)
- **API prefix**: all endpoints under `/api/`
- **Auth**: Sa-Token, UUID tokens, 24h timeout, token via `Authorization` header
- **Service pattern**: `ServiceImpl<Mapper, Entity>` with interface + impl
- **Controller annotations**: `@Tag`, `@Operation` (OpenAPI), `@RequiredArgsConstructor`
- **MyBatis Plus**: auto-fill createTime/updateTime/deleted, underscore-to-camelCase mapping

### Business Domain Internal Structure

Each domain follows: `controller/` → `dto/` → `entity/` → `mapper/` → `service/` → `service/impl/` → `vo/`

## Rules

- Do not rename base packages, module names, or API response formats
- New features go into the appropriate existing module
- Output a plan before complex changes — no mass edits directly
- Pay attention to public/private content permission isolation
- File uploads must consider security
- Design for future AI capability integration
