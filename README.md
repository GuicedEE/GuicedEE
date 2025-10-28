# 🧩 GuicedEE Framework

> *Modern Modular Java — Human-Centric, Fast, and Fearlessly Simple.*

[![Build Status](https://img.shields.io/github/actions/workflow/status/GuicedEE/GuicedEE/build.yml?branch=master&style=flat-square)](https://github.com/GuicedEE/GuicedEE/actions)
[![Release Workflow](https://img.shields.io/github/actions/workflow/status/GuicedEE/GuicedEE/release.yml?branch=master&label=Release%20Workflow&color=8A2BE2&style=flat-square)](https://github.com/GuicedEE/GuicedEE/actions/workflows/release.yml)
[![Version](https://img.shields.io/badge/Version-SNAPSHOT-orange?style=flat-square)](#)
[![AI-Aligned (optional)](https://img.shields.io/badge/AI%E2%80%91Aligned-optional-lightgrey?style=flat-square)](https://github.com/GuicedEE/ai-rules)
[![JDK](https://img.shields.io/badge/JDK-25%2B-007396?style=flat-square)](https://openjdk.org/projects/jdk/25/)
[![Maven](https://img.shields.io/badge/Maven-%E2%89%A53.9.1-6E3FCE?style=flat-square)](https://maven.apache.org/)
[![Vert.x](https://img.shields.io/badge/Vert.x-5.0-4B4BFF?style=flat-square)](https://vertx.io/)
[![JPMS Level](https://img.shields.io/badge/JPMS-Level%203-008080?style=flat-square)](#)
[![License](https://img.shields.io/badge/License-Apache%202.0-green?style=flat-square)](LICENSE)
[![Contributions Welcome](https://img.shields.io/badge/contributions-welcome-brightgreen?style=flat-square)](https://github.com/GuicedEE/GuicedEE/discussions)

---

### 👋 Welcome

GuicedEE is a **Level-3 modular Java framework** built on **Guice** and **Vert.x 5**, engineered for modern, cloud-native applications.
It is designed to be **fast, transparent, and vendor-neutral**, using **JPMS modules**, **service loaders**, and **post-injection AOP** to deliver true modularity — without the weight of traditional enterprise stacks.

> This project isn’t about reinventing Java EE — it’s about rediscovering *clarity and craft* in Java software design.

---


> ⚠️ **Currently in active SNAPSHOT development**

**AI-Aligned (optional):** IDE agents like **JetBrains Junie**, **GitHub Copilot**, **Cursor**, and **Claude** can read the [ai-rules](https://github.com/GuicedEE/ai-rules) to understand GuicedEE’s architecture and conventions.


## ✅ Requirements

- **JDK 25+**
- **Maven 3.9.1+**

---

## ✨ Why GuicedEE?

- **100% JPMS-compliant:** Real modular builds with `module-info.java`
- **Reactive by default:** Built on Vert.x 5 and Hibernate Reactive 7
- **Dependency-light:** Uses Guice for IoC, no fat-JARs, no vendor lock-in
- **Cross-module injection:** via service loaders + custom Guice bindings
- **Cloud-native runtime:** JLink images for minimal, secure deployments
- **Community-driven:** open, modular, and friendly
- **Version-managed:** via [`guicedee-bom`](https://github.com/GuicedEE/guicedee-bom)

---

## ⚡ Quick Start (For contributors)

```bash
git clone https://github.com/GuicedEE/GuicedEE.git
cd GuicedEE
mvn clean install
```

Add it to your project (versions are managed by the BOM):

```xml
<dependencyManagement>
  <dependencies>
    <dependency>
      <groupId>com.guicedee</groupId>
      <artifactId>guicedee-bom</artifactId>
      <type>pom</type>
      <scope>import</scope>
    </dependency>
  </dependencies>
</dependencyManagement>

<dependencies>
  <dependency>
    <groupId>com.guicedee</groupId>
    <artifactId>guicedee</artifactId>
  </dependency>
</dependencies>
```

---

## 🧬 The GuicedEE Ecosystem

> *Each module builds on the one before it — a living chain of modular components.*

| Chain | Description |
|-------|--------------|
| [![GuicedInjection](https://img.shields.io/badge/GuicedInjection-core-blue?style=flat-square)](https://github.com/GuicedEE/GuicedInjection) | Foundation IoC and AOP layer |
| ➡️ [![Persistence](https://img.shields.io/badge/Persistence-reactive-yellow?style=flat-square)](https://github.com/GuicedEE/Persistence) | Reactive database and entity management |
| ➡️ [![Guiced-Vert.x](https://img.shields.io/badge/Vert.x-Integration-purple?style=flat-square)](https://github.com/GuicedEE/Guiced-Vert.x) | Vert.x 5 reactive core integration |
| ➡️ [![Vertx Web](https://img.shields.io/badge/Vert.x-Web-4B4BFF?style=flat-square)](https://github.com/GuicedEE/GuicedVertxWeb) | HTTP routing, handlers, middleware |
| ➡️ [![Vertx Persistence](https://img.shields.io/badge/Vert.x-Persistence-4B4BFF?style=flat-square)](https://github.com/GuicedEE/GuicedVertxPersistence) | Reactive DB helpers for Vert.x |
| ➡️ [![Session Per Tx](https://img.shields.io/badge/Vert.x-Session_per_Tx-4B4BFF?style=flat-square)](https://github.com/GuicedEE/GuicedVertxSessionPerTransaction) | Session-per-transaction strategy |
| ➡️ [![Telemetry](https://img.shields.io/badge/Telemetry-observability-orange?style=flat-square)](https://github.com/GuicedEE/GuicedTelemetry) | Metrics, tracing, and OpenTelemetry |
| ➡️ [![Sockets](https://img.shields.io/badge/Vert.x-Sockets-4B4BFF?style=flat-square)](https://github.com/GuicedEE/GuicedVertxSockets) | WS/SSE integration |
| ➡️ [![WebSockets](https://img.shields.io/badge/Jakarta-WebSockets-lightgrey?style=flat-square)](https://github.com/GuicedEE/WebSockets) | Jakarta WebSocket layer |
| ➡️ [![REST](https://img.shields.io/badge/REST-Services-lightgrey?style=flat-square)](https://github.com/GuicedEE/RestServices) | REST scaffolding |
| ➡️ [![Servlets](https://img.shields.io/badge/Jakarta-Servlets-lightgrey?style=flat-square)](https://github.com/GuicedEE/Servlets) | Jakarta Servlet integrations |
| ➡️ [![Undertow](https://img.shields.io/badge/Undertow-server-lightgrey?style=flat-square)](https://github.com/GuicedEE/Undertow) | Undertow server bindings |
| ➡️ [![OpenAPI](https://img.shields.io/badge/OpenAPI-generated-lightgrey?style=flat-square)](https://github.com/GuicedEE/OpenAPI) | OpenAPI codegen |
| ➡️ [![SwaggerUI](https://img.shields.io/badge/Swagger-UI-lightgrey?style=flat-square)](https://github.com/GuicedEE/SwaggerUI) | Swagger UI packaging |
| ➡️ [![Hazelcast](https://img.shields.io/badge/Hazelcast-cache-blue?style=flat-square)](https://github.com/GuicedEE/Hazelcast) | Distributed caching |
| ➡️ [![Hazelcast-Hibernate](https://img.shields.io/badge/Hibernate-2L_cache-blue?style=flat-square)](https://github.com/GuicedEE/Hazelcast-Hibernate) | Hibernate L2 cache |
| ➡️ [![RabbitMQ](https://img.shields.io/badge/RabbitMQ-integration-yellow?style=flat-square)](https://github.com/GuicedEE/GuicedRabbit) | Messaging adapters |
| ➡️ [![IntelliJ Plugin](https://img.shields.io/badge/IntelliJ_Plugin-tools-lightgrey?style=flat-square)](https://github.com/GuicedEE/GuicedEEIntelliJPlugin) | Developer experience tools |
| ➡️ [![Examples](https://img.shields.io/badge/Examples-live_demos-success?style=flat-square)](https://github.com/GuicedEE/Examples) | Real-world implementations and demos |

> Also see: **[ai-rules](https://github.com/GuicedEE/ai-rules)** — a curated set of prompt/rule files to auto-assist IDE AI agents (Junie / Copilot / Claude) when working with GuicedEE.

---

## 🏗️ Architecture at a Glance

```mermaid
graph TD
    A[GuicedInjection<br/>IoC + AOP] --> B[Persistence<br/>Reactive Data]
    B --> C[Vert.x Integration<br/>Web / Event Bus]
    C --> C1[Vertx Web]
    C --> C2[Vertx Persistence]
    C --> C3[Session per Tx]
    C --> D[Telemetry<br/>Metrics / Tracing]
    D --> E[IntelliJ Plugin<br/>Dev Tools]
    E --> F[Examples<br/>Real Apps]
    subgraph Core
      A
    end
    subgraph Reactive Stack
      B
      C
      C1
      C2
      C3
    end
    subgraph Platform
      D
      E
      F
    end
```

---

## 🤝 Contributing

We believe in *open craftsmanship*.
If you’re exploring GuicedEE, contributing docs, or experimenting with reactive modules — you’re already part of the family.

- 💬 [Start a discussion](https://github.com/GuicedEE/GuicedEE/discussions)
- 🪶 [Report an issue](https://github.com/GuicedEE/GuicedEE/issues)
- 🧩 [Read the rules](https://github.com/GuicedEE/junie-guides/blob/master/RULES.md)
- 🤖 [AI setup helpers](https://github.com/GuicedEE/ai-rules)

---

## 🪴 Our Philosophy

> “We design, document, and build together.”

GuicedEE exists to make modular Java human again — approachable, performant, and precise.
We value clarity over cleverness, and community over control.

---


## 🧾 Status
GuicedEE is currently in active **SNAPSHOT** development.
Stable releases are published via [guicedee-bom](https://github.com/GuicedEE/guicedee-bom/tags).

[![Release Workflow](https://img.shields.io/github/actions/workflow/status/GuicedEE/GuicedEE/release.yml?branch=master&label=Release%20Workflow&color=8A2BE2&style=flat-square)](https://github.com/GuicedEE/GuicedEE/actions/workflows/release.yml)

All releases are coordinated via the Release Workflow above, ensuring consistent artifact promotion and BOM tagging.

| Channel | Description |
|----------|-------------|
| SNAPSHOT | Development versions built from `master` |
| Stable | Tagged versions in `guicedee-bom` |
| AI-Aligned | Optional configuration for IDE agents (Junie / Copilot / Cursor / Claude) |

---




## 📜 License

Apache License 2.0  
See [LICENSE](LICENSE) for full text.

---

🪄 *Built with Guice. Powered by Vert.x. Designed with intent.*