# 🧩 GuicedEE Framework

> *Modern Modular Java — Human-Centric, Fast, and Fearlessly Simple.*

[![Build Status](https://img.shields.io/github/actions/workflow/status/GuicedEE/GuicedEE/build.yml?branch=master&style=flat-square)](https://github.com/GuicedEE/GuicedEE/actions)
[![Java](https://img.shields.io/badge/Java-24%2B-007396?style=flat-square)](https://openjdk.org/projects/jdk/24/)
[![Vert.x](https://img.shields.io/badge/Vert.x-5.0-4B4BFF?style=flat-square)](https://vertx.io/)
[![JPMS Level](https://img.shields.io/badge/JPMS-Level%203-008080?style=flat-square)](#)
[![License](https://img.shields.io/badge/License-Apache%202.0-green?style=flat-square)](LICENSE)
[![Contributions Welcome](https://img.shields.io/badge/contributions-welcome-brightgreen?style=flat-square)](https://github.com/GuicedEE/GuicedEE/discussions)

---

### 👋 Welcome

GuicedEE is a **Level-3 modular Java framework** built on top of **Guice** and **Vert.x 5**, engineered for modern, cloud-native applications.  
It is designed to be **fast, transparent, and vendor-neutral**, using **JPMS modules**, **service loaders**, and **post-injection AOP** to deliver true modularity — without the weight of traditional enterprise stacks.

> This project isn’t about reinventing Java EE — it’s about rediscovering *clarity and craft* in Java software design.

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

## ⚡ Quick Start

```bash
git clone https://github.com/GuicedEE/GuicedEE.git
cd GuicedEE
mvn clean install
```

Add it to your project (versions are controlled by the BOM):

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
| ➡️ [![Telemetry](https://img.shields.io/badge/Telemetry-observability-orange?style=flat-square)](https://github.com/GuicedEE/GuicedTelemetry) | Metrics, tracing, and OpenTelemetry |
| ➡️ [![IntelliJ Plugin](https://img.shields.io/badge/IntelliJ_Plugin-tools-lightgrey?style=flat-square)](https://github.com/GuicedEE/GuicedEEIntelliJPlugin) | Developer experience tools |
| ➡️ [![Examples](https://img.shields.io/badge/Examples-live_demos-success?style=flat-square)](https://github.com/GuicedEE/Examples) | Real-world implementations and demos |

---

## 🏗️ Architecture at a Glance

```mermaid
graph TD
    A[GuicedInjection<br/>IoC + AOP] --> B[Persistence<br/>Reactive Data]
    B --> C[Vert.x Integration<br/>Event Loop / Web]
    C --> D[Telemetry<br/>Metrics / Tracing]
    D --> E[IntelliJ Plugin<br/>Dev Tools]
    E --> F[Examples<br/>Real Apps]
    subgraph Core
      A
    end
    subgraph Reactive Stack
      B
      C
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
- 🧭 [Follow the prompts](https://github.com/GuicedEE/junie-guides/tree/master/generative)

---

## 🪴 Our Philosophy

> “We design, document, and build together.”

GuicedEE exists to make modular Java human again — approachable, performant, and precise.  
We value clarity over cleverness, and community over control.

---

## 📜 License

Apache License 2.0  
See [LICENSE](LICENSE) for full text.

---

🪄 *Built with Guice. Powered by Vert.x. Designed with intent.*