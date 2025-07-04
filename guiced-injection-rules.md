# GuicedInjection Framework Guidelines

This document provides comprehensive guidelines for using the GuicedInjection framework, including package structure, SPI implementation, module configuration, and best practices.

## Table of Contents

1. [Overview](#overview)
2. [Package Structure](#package-structure)
3. [SPI Implementation](#spi-implementation)
   - [Creating SPI Interfaces](#creating-spi-interfaces)
   - [Implementing SPI Interfaces](#implementing-spi-interfaces)
   - [Registering SPI Implementations](#registering-spi-implementations)
4. [Module Configuration](#module-configuration)
   - [module-info.java](#module-infojava)
   - [META-INF/services](#meta-infservices)
5. [Lifecycle Management](#lifecycle-management)
   - [Startup Sequence](#startup-sequence)
   - [Shutdown Sequence](#shutdown-sequence)
6. [Integration with Vert.x](#integration-with-vertx)
   - [Verticle Configuration](#verticle-configuration)
   - [Vert.x 5 Migration](#vertx-5-migration)
7. [Common Use Cases](#common-use-cases)
   - [Dependency Injection](#dependency-injection)
   - [Service Discovery](#service-discovery)
   - [Configuration Management](#configuration-management)
8. [Best Practices](#best-practices)
9. [Troubleshooting](#troubleshooting)

## Overview

GuicedInjection is a framework that provides dependency injection, service discovery, and lifecycle management capabilities for Java applications. It is built on top of Google Guice and integrates with various technologies such as Vert.x, JPA, and more.

The framework uses Java's Service Provider Interface (SPI) mechanism to enable extensibility and modularity. It also leverages the Java Module System (JPMS) to provide strong encapsulation and explicit dependencies.

## Package Structure

The GuicedInjection framework follows a modular package structure that separates concerns and promotes maintainability. Here's the recommended package structure for modules built with GuicedInjection:

```
com.guicedee.[module]
├── core                  # Core components
│   ├── Module.java       # Main Guice module
│   └── Config.java       # Configuration class
├── spi                   # Service Provider Interfaces
│   ├── ServiceInterface.java  # SPI interface
│   └── impl              # Default implementations
│       └── ServiceImpl.java   # Default implementation
├── annotations           # Annotations for the module
├── lifecycle             # Lifecycle management components
│   ├── PreStartup.java   # Pre-startup hook
│   └── PreDestroy.java   # Pre-destroy hook
└── util                  # Utility classes
```

## SPI Implementation

### Creating SPI Interfaces

SPI interfaces should be placed in the `spi` package and should follow these guidelines:

1. Use a descriptive name that ends with a verb or noun indicating its purpose
2. Extend marker interfaces when appropriate (e.g., `IGuicePreStartup`, `IGuiceModule`)
3. Keep the interface focused on a single responsibility
4. Document the interface thoroughly with Javadoc

Example:

```java
package com.guicedee.module.spi;

import com.guicedee.guicedinjection.interfaces.IGuicePreStartup;

/**
 * Interface for components that need to perform actions before the application starts.
 */
public interface ModulePreStartup extends IGuicePreStartup {
    /**
     * Performs pre-startup actions for the module.
     */
    @Override
    void onStartup();
}
```

### Implementing SPI Interfaces

Implementations of SPI interfaces should follow these guidelines:

1. Place implementations in an `impl` subpackage or in a separate module
2. Name implementations clearly, typically ending with "Impl" or a descriptive term
3. Implement only the methods defined in the interface
4. Use constructor injection for dependencies when possible
5. Keep implementations stateless when possible

Example:

```java
package com.guicedee.module.spi.impl;

import com.guicedee.module.spi.ModulePreStartup;

public class DefaultModulePreStartup implements ModulePreStartup {
    @Override
    public void onStartup() {
        // Perform pre-startup actions
    }
}
```

### Registering SPI Implementations

SPI implementations can be registered using either the Java Module System or the META-INF/services mechanism:

#### Using the Java Module System:

In your `module-info.java` file:

```java
module com.guicedee.module {
    requires com.guicedee.guicedinjection;

    provides com.guicedee.guicedinjection.interfaces.IGuicePreStartup 
        with com.guicedee.module.spi.impl.DefaultModulePreStartup;
}
```

#### Using META-INF/services:

Create a file at `META-INF/services/com.guicedee.guicedinjection.interfaces.IGuicePreStartup` with the content:

```
com.guicedee.module.spi.impl.DefaultModulePreStartup
```

## Module Configuration

### module-info.java

The `module-info.java` file should be placed at the root of your module's source directory and should follow these guidelines:

1. Use a descriptive name for your module, typically following the base package name
2. Explicitly declare all dependencies using `requires`
3. Use `requires transitive` for dependencies that should be exposed to consumers
4. Export only the packages that are part of your public API using `exports`
5. Open packages that need reflection access using `opens`
6. Declare service providers using `provides ... with ...`
7. Declare service consumers using `uses ...`

Example:

```java
module com.guicedee.module {
    // Core dependencies
    requires transitive com.guicedee.guicedinjection;
    requires transitive com.google.guice;

    // Optional dependencies
    requires static lombok;

    // Exports
    exports com.guicedee.module.core;
    exports com.guicedee.module.spi;

    // Opens for reflection
    opens com.guicedee.module.core to com.google.guice;

    // Service providers
    provides com.guicedee.guicedinjection.interfaces.IGuiceModule 
        with com.guicedee.module.core.Module;
    provides com.guicedee.guicedinjection.interfaces.IGuicePreStartup 
        with com.guicedee.module.spi.impl.DefaultModulePreStartup;

    // Service consumers
    uses com.guicedee.module.spi.ModuleService;
}
```

### META-INF/services

The META-INF/services mechanism can be used alongside or instead of the Java Module System for registering SPI implementations. Follow these guidelines:

1. Create a file in the `META-INF/services` directory with the fully qualified name of the SPI interface
2. Add the fully qualified name of each implementation on a separate line
3. Ensure the file is included in your JAR file

Example:

File: `META-INF/services/com.guicedee.guicedinjection.interfaces.IGuicePreStartup`
```
com.guicedee.module.spi.impl.DefaultModulePreStartup
```

## Lifecycle Management

### Startup Sequence

The GuicedInjection framework follows a specific startup sequence:

1. Load configuration
2. Initialize the scanner
3. Load pre-startup services
4. Execute pre-startup hooks
5. Build the Guice injector
6. Load post-startup services
7. Execute post-startup hooks

To hook into this sequence, implement one of the following interfaces:

- `IGuicePreStartup`: Executed before the Guice injector is built
- `IGuicePostStartup`: Executed after the Guice injector is built

Example:

```java
package com.guicedee.module.lifecycle;

import com.guicedee.guicedinjection.interfaces.IGuicePreStartup;

public class ModuleInitializer implements IGuicePreStartup {
    @Override
    public void onStartup() {
        // Initialize module resources
    }
}
```

### Shutdown Sequence

The GuicedInjection framework also provides a shutdown sequence:

1. Execute pre-destroy hooks
2. Destroy the Guice injector
3. Clean up resources

To hook into this sequence, implement the `IGuicePreDestroy` interface:

```java
package com.guicedee.module.lifecycle;

import com.guicedee.guicedinjection.interfaces.IGuicePreDestroy;

public class ModuleCleaner implements IGuicePreDestroy {
    @Override
    public void onDestroy() {
        // Clean up module resources
    }
}
```

## Integration with Vert.x

### Verticle Configuration

GuicedInjection integrates with Vert.x through the `@Verticle` annotation, which allows you to configure Vert.x verticles with various options:

```java
@Verticle(
    threadingModel = ThreadingModel.VIRTUAL_THREAD,
    workerPoolName = "my-worker-pool",
    workerPoolSize = 10,
    capabilities = {Verticle.Capabilities.Rest, Verticle.Capabilities.Web}
)
public class MyVerticle extends AbstractVerticle {
    @Override
    public void start(Promise<Void> startPromise) {
        // Verticle initialization code
    }
}
```

The `@Verticle` annotation supports the following options:

- `threadingModel`: Specifies the threading model (EVENT_LOOP, WORKER, or VIRTUAL_THREAD)
- `defaultInstances`: Number of instances to deploy
- `ha`: Whether high availability is enabled
- `workerPoolName`: Name of the worker pool
- `workerPoolSize`: Size of the worker pool
- `maxWorkerExecuteTime`: Maximum time a worker thread can execute
- `maxWorkerExecuteTimeUnit`: Time unit for maxWorkerExecuteTime
- `capabilities`: Array of capabilities to enable

### Vert.x 5 Migration

When migrating from Vert.x 4 to Vert.x 5, follow these guidelines:

1. Use Future-based APIs instead of callback-based APIs
2. Replace RxJava2 with Mutiny for reactive programming
3. Replace CLI and OpenTracing with Picocli and OpenTelemetry
4. Upgrade HTTP/WebSocket clients to use builder-based patterns
5. Use `Vertx.builder()` to compose the runtime

Example:

```java
// Vert.x 4
Vertx vertx = Vertx.vertx();

// Vert.x 5
Vertx vertx = Vertx.builder().build();
```

## Common Use Cases

### Dependency Injection

GuicedInjection uses Google Guice for dependency injection. Here's how to use it:

```java
// Inject dependencies
@Inject
private MyService service;

// Get an instance from the injector
MyService service = GuiceContext.instance().inject(MyService.class);
```

### Service Discovery

GuicedInjection provides service discovery through the SPI mechanism:

```java
// Get all implementations of an SPI interface
Set<MyService> services = GuiceContext.instance()
    .getLoader(MyService.class, ServiceLoader.load(MyService.class));
```

### Configuration Management

GuicedInjection provides configuration management through the `GuiceConfig` class:

```java
// Get a configuration value
String value = GuiceContext.instance().getConfig()
    .getProperty("my.property", "default-value");
```

## Best Practices

1. **Follow the Single Responsibility Principle**: Each class should have a single responsibility
2. **Use Constructor Injection**: Prefer constructor injection over field injection for better testability
3. **Keep Services Stateless**: Services should be stateless when possible to avoid concurrency issues
4. **Use Interfaces**: Define interfaces for services to promote loose coupling
5. **Document Your Code**: Use Javadoc to document your code, especially SPI interfaces
6. **Use Appropriate Scopes**: Use the appropriate Guice scope for your services (Singleton, RequestScoped, etc.)
7. **Avoid Circular Dependencies**: Design your services to avoid circular dependencies
8. **Use Proper Exception Handling**: Handle exceptions appropriately and provide meaningful error messages
9. **Write Unit Tests**: Write unit tests for your services to ensure they work as expected
10. **Follow Naming Conventions**: Use consistent naming conventions for classes, methods, and packages

## Troubleshooting

### Common Issues

1. **Service Not Found**: Ensure your service is properly registered in `module-info.java` or `META-INF/services`
2. **Circular Dependency**: Restructure your code to break the circular dependency
3. **ClassNotFoundException**: Ensure the class is in the classpath and the module is properly declared
4. **NoClassDefFoundError**: Check for missing dependencies or version conflicts
5. **IllegalStateException**: Check for improper initialization or usage of services

### Debugging Tips

1. Enable debug logging to see more detailed information:

```
System.setProperty("guicedee.debug", "true");
```

2. Use the `getScanResult()` method to inspect the classpath:

```
ScanResult scanResult = GuiceContext.instance().getScanResult();
ClassInfoList classes = scanResult.getClassesImplementing("com.guicedee.module.spi.MyService");
```

3. Check the Guice injector for binding errors:

```
try {
    Injector injector = GuiceContext.instance().inject();
} catch (CreationException e) {
    e.getErrorMessages().forEach(System.err::println);
}
```
