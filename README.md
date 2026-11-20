# 🧩 GuicedEE Framework

> *Modern Modular Java — Human-Centric, Fast, and Fearlessly Simple.*

[![Maven Package](https://img.shields.io/github/actions/workflow/status/GuicedEE/GuicedEE/maven-publish.yml?branch=master&label=Maven%20Package&style=flat-square)](https://github.com/GuicedEE/GuicedEE/actions/workflows/maven-publish.yml)
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

### Optional standalone WASI experiment

Initialize the pinned `GuicedWasm` submodule to run Java, Guice, and WASI HTTP
feasibility probes separately from the JVM framework build.

```bash
git submodule update --init -- GuicedWasm
```

Build steps and the loopback JSON contract are in the
[standalone WASI guide](https://github.com/GuicedEE/guicedee-wasi-experiment/blob/450446b67780bc944842ebb0a15e75fbfd5ff5d9/docs/inbound-json-proof.md).

## 🧬 The GuicedEE Ecosystem

> Active modules in this repository. Deprecated/removed modules have been excluded.

| Module | Description |
|--------|-------------|
| [![GuicedInjection](https://img.shields.io/badge/GuicedInjection-core-blue?style=flat-square)](https://github.com/GuicedEE/GuicedInjection) | Foundation IoC and AOP layer |
| ➡️ [![Guiced-Vert.x](https://img.shields.io/badge/Vert.x-Integration-purple?style=flat-square)](https://github.com/GuicedEE/Guiced-Vert.x) | Vert.x 5 reactive core integration |
| ➡️ [![Vertx Web](https://img.shields.io/badge/Vert.x-Web-4B4BFF?style=flat-square)](https://github.com/GuicedEE/GuicedVertxWeb) | HTTP routing, handlers, middleware |
| ➡️ [![REST Services](https://img.shields.io/badge/Guiced-REST-lightgrey?style=flat-square)](https://github.com/GedMarc/GuicedRestServices) | REST scaffolding |
| ➡️ [![Web Services](https://img.shields.io/badge/Guiced-Web_Services-lightgrey?style=flat-square)](https://github.com/GedMarc/Guiced-WebServices) | SOAP/Web service helpers |
| ➡️ [![OpenAPI](https://img.shields.io/badge/Guiced-Swagger-lightgrey?style=flat-square)](https://github.com/GedMarc/GuicedSwagger) | OpenAPI integration |
| ➡️ [![SwaggerUI](https://img.shields.io/badge/Swagger-UI-lightgrey?style=flat-square)](https://github.com/GedMarc/Guiced-SwaggerUI) | Swagger UI packaging |
| ➡️ [![Vertx Persistence](https://img.shields.io/badge/Vert.x-Persistence-4B4BFF?style=flat-square)](https://github.com/GedMarc/GuicedVertxPersistence) | Reactive DB helpers for Vert.x |
| ➡️ [![Hazelcast](https://img.shields.io/badge/Hazelcast-cache-blue?style=flat-square)](https://github.com/GedMarc/GuicedHazelcast) | Distributed caching |
| ➡️ [![Telemetry](https://img.shields.io/badge/Telemetry-observability-orange?style=flat-square)](https://github.com/GuicedEE/GuicedTelemetry) | Metrics, tracing, and OpenTelemetry |
| ➡️ [![MicroProfile Config](https://img.shields.io/badge/MicroProfile-Config-00897B?style=flat-square)](https://github.com/GuicedEE/GuicedEE/tree/master/GuicedEE/GuicedMicroProfileConfig) | MicroProfile Config implementation and bridge |
| ➡️ [![Sockets](https://img.shields.io/badge/Vert.x-Sockets-4B4BFF?style=flat-square)](https://github.com/GuicedEE/GuicedVertxSockets) | WS/SSE integration |
| ➡️ [![RabbitMQ](https://img.shields.io/badge/RabbitMQ-integration-yellow?style=flat-square)](https://github.com/GuicedEE/GuicedRabbit) | Messaging adapters |
| ➡️ [![CDI](https://img.shields.io/badge/CDI-bridge-lightgrey?style=flat-square)](https://github.com/GuicedEE/GuicedCDI) | CDI compatibility bridge |
| ➡️ [![Cerial](https://img.shields.io/badge/Serial-Ports-lightgrey?style=flat-square)](https://github.com/GedMarc/GuicedCerial) | Serial/COM port utilities |

> Also see: **[ai-rules](https://github.com/GuicedEE/ai-rules)** — a curated set of prompt/rule files to auto-assist IDE AI agents (Junie / Copilot / Claude / Codex / Roo) when working with GuicedEE.

---

## 🏗️ Architecture at a Glance

```mermaid
graph TD
  %% Core
  subgraph Core
    A[GuicedInjection<br/>IoC + AOP]
  end

  %% Runtime (Vert.x centric)
  subgraph Runtime
    V[Vert.x Integration<br/>Event Bus + Core]
    A --> V

    %% Vert.x Web and friends
    subgraph "Vert.x Web"
      V1[Vertx Web]
      V --> V1
      V1 --> R[REST Services]
      V1 --> W[Web Services]
      V1 --> O[OpenAPI - Swagger]
      V1 --> UI[Swagger UI]
      V1 --> S[Vertx Sockets]
    end

    %% Vert.x Persistence and caching
    subgraph "Vert.x Persistence"
      P[Vertx Persistence]
      V --> P
      P --> H[Hazelcast v7 Reactive]
    end

    %% Cross-cutting integrations
    V --> T[Telemetry]
    V --> CFG[MicroProfile Config]
    V --> MQ[RabbitMQ]
  end

  %% Platform/Tooling
  subgraph Platform
    C[CDI Bridge]
    IDE[IntelliJ Plugin]
    EX[Examples]
  end

  %% Relationships to platform components
  A --> C
  A --> IDE
  IDE --> EX
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

[![Maven Package](https://img.shields.io/github/actions/workflow/status/GuicedEE/GuicedEE/maven-publish.yml?branch=master&label=Maven%20Package&color=8A2BE2&style=flat-square)](https://github.com/GuicedEE/GuicedEE/actions/workflows/maven-publish.yml)

All releases are coordinated via the Release Workflow above, ensuring consistent artifact promotion and BOM tagging.

| Channel | Description                                                                             |
|----------|-----------------------------------------------------------------------------------------|
| SNAPSHOT | Development versions built from `master`                                                |
| Stable | Tagged versions in `guicedee-bom`                                                       |
| AI-Aligned | Optional configuration for IDE agents (Junie / Copilot / Cursor / Claude / Codex / Roo) |

---




## 📜 License

Apache License 2.0  
See [LICENSE](LICENSE) for full text.

---

🪄 *Built with Guice. Powered by Vert.x. Designed with intent.*